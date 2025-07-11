package com.px.partybuild.controller;

import com.px.partybuild.AppConfig;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.controller.jsonmodel.SyncModel;
import com.px.partybuild.service.FileService;
import com.px.partybuild.service.MessageService;
import com.px.partybuild.service.SyncService;
import com.px.partybuild.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/partyweb/sync")
public class SyncController {

    private final Logger logger;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private SyncService syncService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private FileService fileService;

    @Autowired
    private AppConfig appConfig;


    public SyncController(){
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @ResponseBody
    @GetMapping("/test")
    public RequsetData<List<Object>> test(){
        SyncModel model=new SyncModel();
        List<String> dRows=new ArrayList<>();
        dRows.add("{\"messageid\":\"ad05e01e4c394a8f9656486f56742581\",\"msgtitle\":\"测试同步3\",\"url\":\"url2\",\"fromuser\":\"user1\",\"touser\":\"user2\",\"sendtime\":\"2019-08-16T11:15:51.000+0800\",\"state\":0,\"operatetime\":\"2019-08-16T11:15:51.000+0800\",\"operatestate\":\"M\",\"syncstate\":\"N\",\"msgcontent\":\"tes11\"}");
        model.setDataRow(dRows);
        model.setDt(new Date());
        model.setWb(true);
        model.setTn("CfMessage");
        model.setToken("xxxxxx");

        return SyncDBDataRow(model);
    }

    @ResponseBody
    @PostMapping("/SyncDBDataRow")
    public RequsetData<List<Object>> SyncDBDataRow(@RequestBody SyncModel model){

        logger.info("SyncDBDataRow,参数[tn="+model.getTn()+"],[wb="+model.getWb()+"],[token="+model.getToken()
                +"][dt="+dateUtils.dateToStrFormat(model.getDt(),"yyyy-MM-dd HH:mm:ss")+"][beginTime="+dateUtils.dateToStrFormat(model.getBeginTime(),"yyyy-MM-dd HH:mm:ss")+"]");
        RequsetData<List<Object>> res=new RequsetData<>();
        if(syncService.isValid(model.getToken(),model.getDt())){
            try {
                res.setItem(syncService.dbdatarows(model.getTn(), model.getWb(), model.getDataRow(),model.getBeginTime()));
            } catch (Exception ex){
                res.setMsg(ex.getMessage());
                res.setSuccess(false);
            }

        } else {
            res.setSuccess(false);
            res.setMsg("内网token验证失败！");
        }

        return res;

    }

    @ResponseBody
    @PostMapping("/SyncDBDataRowResult")
    public RequsetData<Integer> SyncDBDataRowResult(@RequestBody SyncModel model){
        RequsetData<Integer> res=new RequsetData<>();
        logger.info("SyncDBDataRowResult,参数[tn="+model.getTn()+"],[wb="+model.getWb()+"],[token="+model.getToken()
                +"][dt="+dateUtils.dateToStrFormat(model.getDt(),"yyyy-MM-dd HH:mm:ss")+"][beginTime="+dateUtils.dateToStrFormat(model.getBeginTime(),"yyyy-MM-dd HH:mm:ss")+"]");
        if(syncService.isValid(model.getToken(),model.getDt())) {
            try {
                if (model.getDataRow() == null) {
                    model.setDataRow(new ArrayList<>());
                }
                List<String> ids = model.getDataRow().stream().map(m -> (String) m).collect(Collectors.toList());
                res.setItem(syncService.dbdatarowresult(model.getTn(), model.getWb(), ids));
            } catch (Exception ex) {
                res.setMsg(ex.getMessage());
                res.setSuccess(false);
            }
        } else {
            res.setSuccess(false);
            res.setMsg("内网token验证失败！");
        }

        return res;
    }

    @ResponseBody
    @PostMapping("/doMessage")
    public RequsetData<Integer> doMessage(@RequestBody SyncModel model){
        RequsetData<Integer> res=new RequsetData<>();

        logger.info("doMessage,参数[token="+model.getToken()+"][dt="+dateUtils.dateToStrFormat(model.getDt(),"yyyy-MM-dd HH:mm:ss")+"]");

        if(syncService.isValid(model.getToken(),model.getDt())) {
            messageService.asyncRemoteMsg();
            res.setItem(1);
            res.setMsg("异步触发成功！");
        }else {
            res.setSuccess(false);
            res.setMsg("内网token验证失败！");
        }

        return res;
    }



    @ResponseBody
    @PostMapping("/ftpFileNeedIdSync")
    public RequsetData<List<Object>> ftpFileNeedIdSync(@RequestBody SyncModel model){
        RequsetData<List<Object>> res=new RequsetData<>();

        logger.info("fileNeedIdSync,参数[token="+model.getToken()+"][dt="+dateUtils.dateToStrFormat(model.getDt(),"yyyy-MM-dd HH:mm:ss")+"]");

        if(syncService.isValid(model.getToken(),model.getDt())) {
            try {
                res.setItem(fileService.fileNeedDown(model.getBeginTime()));
            } catch (Exception ex){
                res.setSuccess(false);
                res.setMsg("内网执行失败："+ex.getMessage());
            }
        } else {
            res.setSuccess(false);
            res.setMsg("内网token验证失败！");
        }

        return res;
    }

    @ResponseBody
    @PostMapping("/ftpFileUpload")
    public RequsetData<Boolean> ftpFileUpload(@RequestBody SyncModel model){
        RequsetData<Boolean> res=new RequsetData<>();

        logger.info("ftpFileUpload,参数[token="+model.getToken()+"][dt="+dateUtils.dateToStrFormat(model.getDt(),"yyyy-MM-dd HH:mm:ss")+"]");

        if(syncService.isValid(model.getToken(),model.getDt())) {
            try {
                res.setItem(fileService.ftpFileUplad(model.getDataRow()));
            } catch (Exception ex){
                res.setSuccess(false);
                res.setMsg("内网执行失败："+ex.getMessage());
            }
        } else {
            res.setSuccess(false);
            res.setMsg("内网token验证失败！");
        }

        return res;
    }


}
