package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.ZzDzzgly;
import com.px.partybuild.model.ZzDzzgly;

public interface DzzglyService {

    public int save(ZzDzzgly record);

    /**
     *
     * @param dwName 党委名称
     * @return
     */
    public PageInfo<ZzDzzgly> list( String dwName);

    /**
     * 党组织选择学习秘书查询
     * 党组织代码
     * @param dzzdm
     * @return
     */
    public PageInfo<ZzDzzgly> selectUser(int pageIndex, int pageSize,String dzzdm,String userName);

    PageInfo<ZzDzzgly> listChooseDW();

    ZzDzzgly selectDzzglyByLoader( String loader);
}
