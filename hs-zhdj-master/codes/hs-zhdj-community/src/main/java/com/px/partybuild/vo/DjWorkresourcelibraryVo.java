package com.px.partybuild.vo;

import com.px.partybuild.model.DjWorkresourcelibrary;
import lombok.Data;

@Data
public class DjWorkresourcelibraryVo extends DjWorkresourcelibrary {
    public String file;
    public String filetypename;
    public String parenttypeid;
    public String username;
    public String ssfltypename;
}
