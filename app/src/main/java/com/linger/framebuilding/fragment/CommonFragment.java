package com.linger.framebuilding.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.linger.framebuilding.R;
import com.linger.framebuilding.activity.OKHttpActivity;
import com.linger.framebuilding.base.BaseFragment;

/**
 * 作者：linger
 * 功能：
 * 创建日期：2021/5/20
 */
public class CommonFragment extends BaseFragment {
    private static final String TAG =CommonFragment.class.getSimpleName() ;
    private ListView mListView;
    /*private String[] datas={"网络请求okhttp","图片下载glide","数据库greenDAO","链式框架RxJava",
            "组件路由ARouter","消息传递通信EventBus","热更新Tinker","插件化框架Replugin",
            "文件下载FileDownloaer","图片选择PhotoPicker","导航指示器ViewpagerIndicator",
            "进度条ProgressWheel","下拉刷新SmartRefreshLayout","......"};*/
    private String[] datas;
    private CommonFragmentAdapter adapter;
    @Override
    protected View initView() {
        Log.e(TAG,"常用框架Framement页面被初始化了......");
        View view=View.inflate(mContext,R.layout.fragment_common_frame,null);
        mListView=view.findViewById(R.id.listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String data=datas[position];
              if(data.toLowerCase().equals("okhttp")){
                  Intent intent=new Intent(mContext,OKHttpActivity.class);
                  startActivity(intent);
              }
            }
        });

        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG,"常用框架Framement数据被初始化了......");
       datas=new String[]{"OKHttp","XUtils3","Retrofit2","Fresco","Glide","greenDao","RxJava", "volley","Gson",
               "FastJson","picasso","evenBus","jscideoplayer","pulltorefresh","Expandablelostview","UniversalVideoView","......"};
        adapter=new CommonFragmentAdapter(mContext,datas);
        mListView.setAdapter(adapter);
    }
}
