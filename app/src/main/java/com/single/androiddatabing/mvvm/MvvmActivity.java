package com.single.androiddatabing.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.single.androiddatabing.R;
import com.single.androiddatabing.bean.User;
import com.single.androiddatabing.databinding.ActivityMvvmBinding;
import com.single.androiddatabing.model.UserModel;

public class MvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        UserModel.Factory factory = new UserModel.Factory(
                getApplication());
        final UserModel model = ViewModelProviders.of(this, factory)
                .get(UserModel.class);
        viewDataBinding.setUserModel(model);
        model.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                model.setUserObservableField(user);
            }
        });
    }
}
