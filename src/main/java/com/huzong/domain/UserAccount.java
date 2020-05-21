package com.huzong.domain;

public class UserAccount extends user_new{
    private Double money;
    private Integer uid;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return super.toString()+"  UserAccount{" +
                "money=" + money +
                ", uid=" + uid +
                '}';
    }
}
