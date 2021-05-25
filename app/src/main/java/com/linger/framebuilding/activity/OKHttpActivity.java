package com.linger.framebuilding.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.linger.framebuilding.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者：linger
 * 功能：
 * 创建日期：2021/5/24
 */
public class OKHttpActivity extends Activity implements View.OnClickListener {
    private static final int GET=1;
    private Button btn_get_post;
    private TextView tv_result;
    private OkHttpClient client = new OkHttpClient();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case GET:
                    tv_result.setText((String) msg.obj);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        btn_get_post=(Button) findViewById(R.id.btn_get_post);
        tv_result=(TextView) findViewById(R.id.tv_result);

        btn_get_post.setOnClickListener(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get_post:  //使用原生的okhttp请求网络数据  get 和 post
                getDataFromGet();
                break;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void getDataFromGet() {
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   String result=get("http://guolin.tech/api/china");
                   Log.e("TAG",result);
                   Message msg=Message.obtain();
                   msg.what=GET;
                   msg.obj=result;
                   handler.sendMessage(msg);
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }).start();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
   private String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
