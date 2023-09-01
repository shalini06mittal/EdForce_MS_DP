package com.techgatha.model;

import java.util.List;

public class UserOrderWrapper {
    private List<OrderWrapper> orders;
    private String memberType;

    public UserOrderWrapper(){}
    public UserOrderWrapper(List<OrderWrapper> orders, String memberType) {
        this.orders = orders;
        this.memberType = memberType;

    }

    public List<OrderWrapper> getBookOrders() {
        return orders;
    }

    public void setBookOrders(List<OrderWrapper> bookOrders) {
        this.orders = bookOrders;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return "UserOrderWrapper{" +
                "orders=" + orders +
                ", memberType='" + memberType + '\'' +
                '}';
    }
}
