package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.DjFundsuseMapper;
import com.px.partybuild.mapper.FundsCQuery;
import com.px.partybuild.model.CfDictionary;
import com.px.partybuild.model.DjFundsuseWithBLOBs;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.service.FundsService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 党组织经费
 *
 * @author H
 */
@Service("fundsService")
public class FundsServiceImpl implements FundsService {

    @Autowired
    private FundsCQuery fundsCquery;

    @Autowired
    private DjFundsuseMapper djFundsuseMapper;

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private DateUtils dateUtils;


    @Override
    public PageInfo<HashMap<String, Object>> getFundsUseList(int page, int rows,String dzzmc, String partyCode, String beginTime, String endTime, Integer expendScope, Integer expendType) {

        List<CfDictionary> dicExpendScope = dictionaryService.getDictionaryListByDicTypeKey("expendScope");
        List<CfDictionary> dicExpendType = dictionaryService.getDictionaryListByDicTypeKey("expendType");

        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = fundsCquery.selectFundsUseList(dzzmc,partyCode, beginTime, endTime, expendScope, expendType);

        for (HashMap<String, Object> item : list) {
            if (item.get("EXPENDSCOPE") != null) {
                item.put("EXPENDSCOPENAME", dictionaryService.getDicByKey(Integer.parseInt(item.get("EXPENDSCOPE").toString()), dicExpendScope).getDicvalue());
            }
            if (item.get("EXPENDTYPE") != null) {
                item.put("EXPENDTYPENAME", dictionaryService.getDicByKey(Integer.parseInt(item.get("EXPENDTYPE").toString()), dicExpendType).getDicvalue());
            }
        }

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);

        return result;
    }

    @Override
    public DjFundsuseWithBLOBs getFundsuseById(String id) {
        return djFundsuseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveFundsuse(DjFundsuseWithBLOBs model, String userId, String userName) {
        int result = 0;
        DjFundsuseWithBLOBs dbModel = getFundsuseById(model.getFundsuseid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getFundsuseid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = djFundsuseMapper.insert(model);
        } else {

            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = djFundsuseMapper.updateByPrimaryKeyWithBLOBs(model);
        }

        return result;
    }

    @Override
    public int deleteFundsuseById(String id) {
        return djFundsuseMapper.deleteByPrimaryKey(id);
    }
    /**
     * @param page
     * @param rows
     * @param partyCode
     * @param year
     * @return
     */
    @Override
    public PageInfo<HashMap<String, Object>> getFundsUsageSummary(int page, int rows, String partyCode, String dzzmc,Integer year,boolean isApp) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = fundsCquery.selectFundsUsageSummary(partyCode, dzzmc,year,null,isApp);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);

        return result;
    }
    @Override
    public HashMap<String, Object> getFundsUsageSummaryByDzzdm(Integer year,String dzzdm) {

        List<HashMap<String, Object>> list = fundsCquery.selectFundsUsageSummary(null,null, year,dzzdm,true);

        return list.stream().findFirst().get();
    }
    /**
     * @param page
     * @param rows
     * @param partyCode
     * @param year
     * @return
     */
    @Override
    public PageInfo<HashMap<String, Object>> getFundsUsageDetails(int page, int rows, String partyCode, Integer year) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = fundsCquery.selectFundsUsageDetails(partyCode, year);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);

        return result;
    }
    /**
     * @param partyCode
     * @param expendscope
     * @param year
     * @return
     */
    @Override
    public  List<HashMap<String, Object>>  getPartyFundsUsage( String partyCode, Integer expendscope,Integer year) {

        List<HashMap<String, Object>> list = fundsCquery.selectPartyFundsUsage(partyCode, expendscope,year);

        return list;
    }
}
