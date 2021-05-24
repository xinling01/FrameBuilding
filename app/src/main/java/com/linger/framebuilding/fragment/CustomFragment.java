package com.linger.framebuilding.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.linger.framebuilding.base.BaseFragment;

/**
 * 作者：linger
 * 功能：
 * 创建日期：2021/5/20
 */
public class CustomFragment extends BaseFragment {
    private static final String TAG =CustomFragment.class.getSimpleName() ;
    private TextView textView;
    @Override
    protected View initView() {
        Log.e(TAG,"自定义Framement页面被初始化了......");
        textView=new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG,"自定义Framement数据被初始化了......");
        textView.setText("自定义页面");
    }
}
