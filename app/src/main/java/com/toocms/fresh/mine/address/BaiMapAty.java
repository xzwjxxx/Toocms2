package com.toocms.fresh.mine.address;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.toocms.fresh.R;

/**
 * Created by Administrator on 2016/3/8.
 */
public class BaiMapAty extends Activity{

    private MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private Marker marker;
    private LatLng point;
    private BitmapDescriptor bitmap;
    private BitmapDescriptor mCurrentMarker;
    private MyLocationConfiguration config;

    private LocationClient mLocationClient;//定位SDK的核心类

    @ViewInject(R.id.show_maplocation)
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
         setContentView(R.layout.baidu_map_mian);
        ViewUtils.inject(this);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        setMark();
        setDarg();
        setmapListener();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }


    /**
     * Mark标志
     */
    private void setMark(){
        //定义Maker坐标点
        point = new LatLng(39.963175, 116.400244);
        //构建Marker图标
        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.mark);
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions().position(point).icon(bitmap);
        //在地图上添加Marker，并显示
        mBaiduMap.addOverlay(option);
    }

    /**
     * 设置可拖拽
     */
    private void setDarg(){
        //设置marker的位置,图标，层级
        OverlayOptions options = new MarkerOptions().position(point).icon(bitmap).zIndex(9).draggable(true);  //设置手势拖拽
        //将marker添加到地图上
        marker = (Marker) (mBaiduMap.addOverlay(options));

    }


    /**
     * 设置监听器
     */
    private void setmapListener(){
        //调用BaiduMap对象的setOnMarkerDragListener方法设置marker拖拽的监听
        mBaiduMap.setOnMarkerDragListener(new BaiduMap.OnMarkerDragListener() {
            public void onMarkerDrag(Marker marker) {
                //拖拽中
            }
            public void onMarkerDragEnd(Marker marker) {
                //拖拽结束
            }
            public void onMarkerDragStart(Marker marker) {
                //开始拖拽
            }
        });

    }


    /**
     * 位置信息上传
     */


//    private class MyAdapter extends BaseAdapter {
//
//        private List<AddressInfo> address;
//        private ViewHolder viewHolder;
//
//        public MyAdapter(List<AddressInfo> address){
//
//            this.address=address;
//        }
//
//        @Override
//        public int getCount() {
//            return (address==null)?0:address.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return position;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                viewHolder = new ViewHolder();
//                convertView = LayoutInflater.from(BaiMapAty.this).inflate(R.layout.mine_address_listitem, parent, false);
//                ViewUtils.inject(viewHolder, convertView);
//                convertView.setTag(viewHolder);
//            } else {
//                viewHolder = (ViewHolder) convertView.getTag();
//            }
//            if (position == 0) viewHolder.imageView.setVisibility(View.VISIBLE);
//            else viewHolder.imageView.setVisibility(View.GONE);
//
//            viewHolder.tvName.setText(address.get(position).getName());
//            viewHolder.tvPhone.setText(address.get(position).getPhone());
//            viewHolder.tvAddress.setText(address.get(position).getAddress());
//
//            return convertView;
//        }
//
//        private class ViewHolder {
//            @ViewInject(R.id.listitem_address_name)
//            public TextView tvName;
//            @ViewInject(R.id.listitem_address_phone)
//            public TextView tvPhone;
//            @ViewInject(R.id.listitem_address_address)
//            public TextView tvAddress;
//            @ViewInject(R.id.listitem_address_default)
//            public ImageView imageView;
//        }
//    }


}
