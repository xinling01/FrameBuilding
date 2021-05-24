package com.linger.framebuilding.fragment;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 作者：linger
 * 功能：
 * 创建日期：2021/5/24
 */
public class CommonFragmentAdapter extends BaseAdapter {
    private final Context mContext;
    private final String[] mDatas;

    public CommonFragmentAdapter(Context context, String[] datas){
        this.mContext=context;
        this.mDatas=datas;
    }
    @Override
    public int getCount() {
        return mDatas.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView=new TextView(mContext);
        textView.setTextColor(Color.BLACK);
        textView.setPadding(30,30,0,30);
        textView.setTextSize(20);
        textView.setText(mDatas[position]);
        return textView;
    }
}
