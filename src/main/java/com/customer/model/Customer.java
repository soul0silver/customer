package com.customer.model;

public class Customer {
    private int cuId;
    private String cuName;
    private int age;
    private String bDay;
    private String phone;
    private int aId;

    public Customer() {
    }

    public int getCuId() {
        return cuId;
    }

    public void setCuId(int cuId) {
        this.cuId = cuId;
    }

    public String getCuName() {
        return cuName;
    }

    public void setCuName(String cuName) {
        this.cuName = cuName;
    }




    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getaId() {
        return aId;
    }

    public Customer(int cuId, String cuName, String bDay, String phone, int aId) {
        this.cuId = cuId;
        this.cuName = cuName;
        this.bDay = bDay;
        this.phone = phone;
        this.aId = aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cuId=" + getCuId() +
                ", cuName='" + getCuName() + '\'' +
                ", bDay='" + getbDay() + '\'' +
                ", phone='" + getaId() + '\'' +
                ", aId=" + getPhone() +
                '}';
    }
}
