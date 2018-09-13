package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;

public class PageBase {

    @JSONField(name = "ItemSize")
    private int itemSize; // 总条数
    @JSONField(name = "PageCount")
    private int pageCount; // 总页数
    @JSONField(name = "PageNo")
    private int pageNo;   // 当前页

    public int getItemSize() {
        return itemSize;
    }

    public void setItemSize(int itemSize) {
        this.itemSize = itemSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

}
