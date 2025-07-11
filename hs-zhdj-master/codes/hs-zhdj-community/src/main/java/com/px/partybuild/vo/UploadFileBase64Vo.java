package com.px.partybuild.vo;

import lombok.Data;

@Data
public class UploadFileBase64Vo {
    public String base64;
    public String fileRefId;
    public Integer fileType;
    public boolean isImage;
}
