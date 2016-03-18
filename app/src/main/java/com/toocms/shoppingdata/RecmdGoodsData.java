package com.toocms.shoppingdata;

/**
 * Created by Administrator on 2016/3/2.
 */
public class RecmdGoodsData {

    private String imageurl;
    private String goodname;
    private String price;

    public RecmdGoodsData(String imageurl, String goodname, String price) {
        this.imageurl = imageurl;
        this.goodname = goodname;
        this.price = price;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getPrice() {
        return price;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
