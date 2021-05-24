package com.linger.framebuilding;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.linger.framebuilding.base.BaseFragment;
import com.linger.framebuilding.fragment.CommonFragment;
import com.linger.framebuilding.fragment.CustomFragment;
import com.linger.framebuilding.fragment.OtherFragment;
import com.linger.framebuilding.fragment.ThirdPartyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：linger
 * 功能：
 * 创建日期：2021/5/19
 */
public class MainActivity extends FragmentActivity {
    private RadioGroup mRg_main;
    private List<BaseFragment>mBaseFragment;
    private int position;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initFragment();
        setListener();
    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener()) ;
        mRg_main.check(R.id.rb_common_frame);
    }
    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_common_frame:
                    position=0;
                    break;
                case R.id.rb_thirdparty:
                    position=1;
                    break;
                case R.id.rb_custom:
                    position=2;
                    break;
                case R.id.rb_other:
                    position=3;
                    break;
                    default:
                        position=0;
                        break;
            }
            //根据位置得到对应的Fragment
            BaseFragment fragment=getFragment();
            //替换
            switchFragment(fragment);
        }
    }

    private void switchFragment(BaseFragment fragment) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.fl_content,fragment);
        transaction.commit();
    }

    /**
     * 根据位置得到的Fragment
     * @return
     */
    private BaseFragment getFragment() {
       BaseFragment fragment= mBaseFragment.get(position);
        return fragment;
    }

    private void initFragment() {
        mBaseFragment=new ArrayList<>();
        mBaseFragment.add(new CommonFragment());
        mBaseFragment.add(new ThirdPartyFragment());
        mBaseFragment.add(new CustomFragment());
        mBaseFragment.add(new OtherFragment());
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mRg_main=findViewById(R.id.rg_main);

    }
}
