package com.px.partybuild.service.impl;

import com.px.partybuild.AppConfig;
import com.px.partybuild.mapper.SyncDynamicCQuery;
import com.px.partybuild.service.CommonService;
import com.px.partybuild.service.SyncService;
import com.px.partybuild.util.JsonMapper;
import com.px.partybuild.util.MyBatisDynamic;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Service("syncService")
public class SyncServiceImpl implements SyncService {

    private final String ModelNamePath;
    private final String MapperNamePath;

    public SyncServiceImpl(){
        ModelNamePath="com.px.partybuild.model.";
        MapperNamePath="com.px.partybuild.mapper.";
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MyBatisDynamic myBatisDynamic;

    @Autowired
    private CommonService commonService;

    @Autowired
    private AppConfig appConfig;


    @Override
    public List<Object> dbdatarows(String tableName, Boolean withBlog, List<String> DBRows, Date beginTime) {

        List<Object> resultRows=new ArrayList<>();
        List<Object> DBModelRows;
        Class<?> mapper,Example,modelClass;
        Object mapBean;
        String primaryKey;

        try{
            modelClass= Class.forName(ModelNamePath+tableName);
            mapper = Class.forName(MapperNamePath+tableName+"Mapper");
            mapBean=applicationContext.getBean(mapper);
            if(DBRows==null){
                DBModelRows=new ArrayList<>();
            } else {
                DBModelRows=DBRows.stream().map(m-> JsonMapper.jsonToObject(m,modelClass)).collect(Collectors.toList());
            }

            primaryKey=modelClass.getDeclaredFields()[0].getName();
            Example = Class.forName(ModelNamePath+tableName+"Example");

        } catch (Exception ex){
            return null;
        }
        //1.添加新增数据

        List<String> allIds = DBModelRows.stream().map(m->myBatisDynamic.GetModelFieldValue(m,primaryKey,String.class)).collect(Collectors.toList());
        List<Object> localDBRows=null;
        if(allIds.size()>0){

            try{
                Object oExp=Example.newInstance();
                Object oCriteria=myBatisDynamic.DoMethod(Example,oExp,"or");
                Map<Class<?>, Object> params=new HashMap<>();
                params.put(List.class,allIds);
                myBatisDynamic.DoMethod(oCriteria.getClass(),oCriteria,"and"+myBatisDynamic.FieldNameFormat(primaryKey)+"In",params);

                if(withBlog){
                    localDBRows=(List<Object>) myBatisDynamic.DoMethod(mapper,mapBean,"selectByExampleWithBLOBs",oExp);
                } else {
                    localDBRows=(List<Object>) myBatisDynamic.DoMethod(mapper,mapBean,"selectByExample",oExp);
                }

            } catch (Exception ex){
                return null;
            }
        }

        if(localDBRows==null){
            localDBRows=new ArrayList<>();
        }

        List<String> existIds = localDBRows.stream().map(m -> myBatisDynamic.GetModelFieldValue(m, primaryKey, String.class)).collect(Collectors.toList());

        //List<String> newIds=allIds.stream().filter(id->!existIds.contains(id)).collect(Collectors.toList());

        List<Object> newRows=DBModelRows.stream().filter(m->!existIds.contains(myBatisDynamic.GetModelFieldValue(m,primaryKey,String.class))).collect(Collectors.toList());

        newRows.forEach(mrow->{
            myBatisDynamic.SetModelFieldValue(mrow,"syncstate","Y");
            myBatisDynamic.DoMethod(mapper,mapBean,"insert",mrow);
            resultRows.add(mrow);
        });


        //2.查找所有相关数据
        if(localDBRows.size()>0){
            //3.按OperateTime时间，获取这边比较新的集合
            List<Object> freshLocalDBRows = localDBRows.stream().filter(f -> DBModelRows.stream().filter(s -> myBatisDynamic.GetModelFieldValue(s,primaryKey,String.class).equals(myBatisDynamic.GetModelFieldValue(f,primaryKey,String.class))
                    && (myBatisDynamic.GetModelFieldValue(s,"operatetime",Date.class).compareTo(myBatisDynamic.GetModelFieldValue(f,"operatetime",Date.class))<0)).count()>0).collect(Collectors.toList());

            resultRows.addAll(freshLocalDBRows);

            //4.获得需要更新列表
            List<String> freshIds = freshLocalDBRows.stream().map(m -> myBatisDynamic.GetModelFieldValue(m,primaryKey,String.class)).collect(Collectors.toList());
            List<Object> needUpdateRows = DBModelRows.stream().filter(s -> !freshIds.contains(myBatisDynamic.GetModelFieldValue(s,primaryKey,String.class))).collect(Collectors.toList());
            //5.更新状态,同步数据库
            needUpdateRows.forEach(row->{
                myBatisDynamic.SetModelFieldValue(row,"syncstate","Y");
                if(withBlog){
                    myBatisDynamic.DoMethod(mapper, mapBean, "updateByPrimaryKeyWithBLOBs", row);
                }else {
                    myBatisDynamic.DoMethod(mapper, mapBean, "updateByPrimaryKey", row);
                }

            });
            resultRows.addAll(needUpdateRows);
        }

        /*
        List<String> ids=DBModelRows.stream().filter(m->!myBatisDynamic.GetModelFieldValue(m,"operatestate",String.class).equals("A"))
                .map(m->myBatisDynamic.GetModelFieldValue(m,primaryKey,String.class)).collect(Collectors.toList());
        */
        //if(ids.size()>0){

             /*
            try{
                Object oExp=Example.newInstance();
                Object oCriteria=myBatisDynamic.DoMethod(Example,oExp,"or");
                Map<Class<?>, Object> params=new HashMap<>();
                params.put(List.class,ids);
                myBatisDynamic.DoMethod(oCriteria.getClass(),oCriteria,"and"+myBatisDynamic.FieldNameFormat(primaryKey)+"In",params);
                //localDBRows=(List<Object>)
                if(withBlog){
                    localDBRows=(List<Object>) myBatisDynamic.DoMethod(mapper,mapBean,"selectByExampleWithBLOBs",oExp);
                } else {
                    localDBRows=(List<Object>) myBatisDynamic.DoMethod(mapper,mapBean,"selectByExample",oExp);
                }

            } catch (Exception ex){
                return null;
            }*/

       // }

        //6.添加新增部分
        try{
            Object oExpNew=Example.newInstance();
            //Date beginDate=DateUtils.addMinutes(new Date(),-30);
            Object oCriteriaNew =myBatisDynamic.DoMethod(Example,oExpNew,"or");
            myBatisDynamic.DoMethod(oCriteriaNew.getClass(),oCriteriaNew,"andSyncstateEqualTo","N");
            myBatisDynamic.DoMethod(oCriteriaNew.getClass(),oCriteriaNew,"andOperatetimeGreaterThan",beginTime);
            List<Object> AddDBRows;
            if(withBlog){
                AddDBRows=(List<Object>)myBatisDynamic.DoMethod(mapper,mapBean,"selectByExampleWithBLOBs",oExpNew);
            } else {
                AddDBRows=(List<Object>)myBatisDynamic.DoMethod(mapper,mapBean,"selectByExample",oExpNew);
            }
            resultRows.addAll(AddDBRows);

        } catch (Exception ex){

        }


        return resultRows;
    }

    @Override
    public Integer dbdatarowresult(String tableName, Boolean withBlog, List<String> ids) {
        int result=0;
        Class<?> mapper,Example,modelClass;
        Object mapBean;
        String primaryKey;
        if(ids.size()>0){
            try{
                modelClass= Class.forName(ModelNamePath+tableName);
                mapper = Class.forName(MapperNamePath+tableName+"Mapper");
                mapBean=applicationContext.getBean(mapper);
                Example = Class.forName(ModelNamePath+tableName+"Example");
                primaryKey=modelClass.getDeclaredFields()[0].getName();

                Object oExp=Example.newInstance();
                Object oCriteria=myBatisDynamic.DoMethod(Example,oExp,"or");

                List<String> dbIds=ids.stream().map(jsonId-> StringUtils.replaceAll(jsonId,"\"","")).collect(Collectors.toList());

                Map<Class<?>, Object> params=new HashMap<>();
                params.put(List.class,dbIds);

                myBatisDynamic.DoMethod(oCriteria.getClass(),oCriteria,"and"+myBatisDynamic.FieldNameFormat(primaryKey)+"In",params);

                Object uModel=modelClass.newInstance();

                myBatisDynamic.SetModelFieldValue(uModel,"syncstate","Y");

                result=(int)myBatisDynamic.DoMethod(mapper,mapBean,"updateByExampleSelective",uModel,oExp);

            } catch (Exception ex){
                result=0;
            }


        }
        return result;
    }

    private String dateFormat="yyyy-MM-dd hh:mm:ss";

    @Override
    public Boolean isValid(String word, Date dt) {

        String localWord=appConfig.appId+","+ DateFormatUtils.format(dt,dateFormat);

        String desWord=commonService.DesDeCode(word,appConfig.secret);

        return localWord.equals(desWord);

    }



}
