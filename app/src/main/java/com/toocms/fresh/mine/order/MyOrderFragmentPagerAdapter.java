package com.toocms.fresh.mine.order;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyOrderFragmentPagerAdapter extends FragmentPagerAdapter{

	 ArrayList<Fragment> list;  
	    public MyOrderFragmentPagerAdapter(FragmentManager fm,ArrayList<Fragment> list) {  
	        super(fm);  
	        this.list = list;  
	          
	    }  

	    @Override  
	    public int getCount() {  
	        return list.size();  
	    }  
	      
	    @Override  
	    public Fragment getItem(int arg0) {  
	        return list.get(arg0);  
	    }  
}
