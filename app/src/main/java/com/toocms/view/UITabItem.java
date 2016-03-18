package com.toocms.view;

/**
 * Created by Administrator on 2016/3/11.
 */
public class UITabItem {

    private int leftdrawable;
    private String lefttitle;
    private String righttitle;
    private int rightdrawable;

    public UITabItem(int leftdrawable, String lefttitle, String righttitle, int rightdrawable) {
        this.leftdrawable = leftdrawable;
        this.lefttitle = lefttitle;
        this.righttitle = righttitle;
        this.rightdrawable = rightdrawable;
    }


    public void setLeftdrawable(int leftdrawable) {
        this.leftdrawable = leftdrawable;
    }

    public void setLefttitle(String lefttitle) {
        this.lefttitle = lefttitle;
    }

    public void setRighttitle(String righttitle) {
        this.righttitle = righttitle;
    }

    public void setRightdrawable(int rightdrawable) {
        this.rightdrawable = rightdrawable;
    }

    public int getLeftdrawable() {
        return leftdrawable;
    }

    public String getLefttitle() {
        return lefttitle;
    }

    public String getRighttitle() {
        return righttitle;
    }

    public int getRightdrawable() {
        return rightdrawable;
    }
}
