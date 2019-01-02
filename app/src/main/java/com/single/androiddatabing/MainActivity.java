package com.single.androiddatabing;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;

import com.single.androiddatabing.bean.User;
import com.single.androiddatabing.databinding.ActivityViewstubBinding;
import com.single.androiddatabing.databinding.LayoutIncludeBinding;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityViewstubBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_viewstub);
        Map<String, User> users = new HashMap();

        User user = new User();
        user.name = "王小二";
        users.put("1", user);

        User user1 = new User();
        user1.name = "王小三";
        users.put("2", user1);

        viewDataBinding.setKey("1");
        viewDataBinding.setUserMap(users);
        viewDataBinding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                LayoutIncludeBinding viewStubBinding = DataBindingUtil.bind(inflated);
                User user = new User(12, "谢后");
                viewStubBinding.setMyUser(user);
            }
        });
        if (!viewDataBinding.viewStub.isInflated()) {
            //viewDataBinding.viewStub获取的是ViewStubProxy
            viewDataBinding.viewStub.getViewStub().inflate();
        }
    }
}
