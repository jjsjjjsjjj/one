package com.CampusMall.Pojo;

public class SearchInfo {
    private String typeId;
    private Long price1;
    private Long price2;
    private String userId;
    private String pName;

    public SearchInfo() {
    }

    public SearchInfo(String typeId, Long price1, Long price2, String userId,String pName) {
        this.typeId = typeId;
        this.price1 = price1;
        this.price2 = price2;
        this.userId = userId;
        this.pName=pName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Long getPrice1() {
        return price1;
    }

    public void setPrice1(Long price1) {
        this.price1 = price1;
    }

    public Long getPrice2() {
        return price2;
    }

    public void setPrice2(Long price2) {
        this.price2 = price2;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "SearchInfo{" +
                "typeId='" + typeId + '\'' +
                ", price1=" + price1 +
                ", price2=" + price2 +
                ", userId='" + userId + '\'' +
                ", pName='" + pName + '\'' +
                '}';
    }
}
