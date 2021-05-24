package com.linger.framebuilding.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.linger.framebuilding.R;

/**
 * 作者：linger
 * 功能：
 * 创建日期：2021/5/24
 */
public class OKHttpActivity extends Activity implements View.OnClickListener {
    private Button btn_get_post;
    private TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        btn_get_post=(Button) findViewById(R.id.btn_get_post);
        tv_result=(TextView) findViewById(R.id.tv_result);

        btn_get_post.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get_post:  //使用原生的okhttp请求网络数据  get 和 post
                break;
        }
    }
}
