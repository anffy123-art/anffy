package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

public interface ZzZxzxxZlService {

    int insertZxzxxZl(String id,String fileId,String docType,String dzzdm);

    PageInfo<HashMap<String,Object>> selectXxzl(String fileName, String dzzdm,String up_begin,String up_end, Integer pageindex, Integer pagesize,String zzfbType,String doctype);

}
