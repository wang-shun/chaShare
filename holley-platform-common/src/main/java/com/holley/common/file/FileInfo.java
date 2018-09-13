package com.holley.common.file;

import java.util.Date;

/**
 * 文件属性相关
 * 
 * @author zhouli
 */
public class FileInfo {

    private String fileName;
    private Long   size;
    private String fileSize;
    private Date   lastModifyed;
    private String lastModifyedStr;
    private String fileType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Date getLastModifyed() {
        return lastModifyed;
    }

    public void setLastModifyed(Date lastModifyed) {
        this.lastModifyed = lastModifyed;
    }

    public String getLastModifyedStr() {
        return lastModifyedStr;
    }

    public void setLastModifyedStr(String lastModifyedStr) {
        this.lastModifyedStr = lastModifyedStr;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

}
