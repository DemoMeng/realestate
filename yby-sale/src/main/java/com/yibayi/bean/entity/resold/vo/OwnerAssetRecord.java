package com.yibayi.bean.entity.resold.vo;

/*
* 业主主页所需统计返回实体
* */
public class OwnerAssetRecord {

    /*
    * 房源所在区域
    * */
    private String areaCount;

    /*
    * 在售房源
    * */
    private String onSaleCount;

    /*
    * 历史成交
    * */
    private String doneCount;


    public String getAreaCount() {
        return areaCount;
    }

    public void setAreaCount(String areaCount) {
        this.areaCount = areaCount;
    }

    public String getOnSaleCount() {
        return onSaleCount;
    }

    public void setOnSaleCount(String onSaleCount) {
        this.onSaleCount = onSaleCount;
    }

    public String getDoneCount() {
        return doneCount;
    }

    public void setDoneCount(String doneCount) {
        this.doneCount = doneCount;
    }
}
