package com.toocms.fresh.mine.address;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/10.
 */
public class AddressInfo implements Serializable{

    private String name;
    private String phone;
    private String address;
    private String detailAddress;
    private String defaultAddress;


    public AddressInfo(String name, String phone, String address, String detailAddress, String defaultAddress) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.detailAddress = detailAddress;
        this.defaultAddress = defaultAddress;
    }


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", defaultAddress='" + defaultAddress + '\'' +
                '}';
    }
}
