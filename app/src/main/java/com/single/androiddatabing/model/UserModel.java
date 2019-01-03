package com.single.androiddatabing.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.single.androiddatabing.bean.User;

/**
 * Created by xiangcheng on 19/1/3.
 */

public class UserModel extends AndroidViewModel {
    public ObservableField<User> userObservableField = new ObservableField<>();
    private final MediatorLiveData<User> userMediatorLiveData = new MediatorLiveData<>();

    public LiveData<User> getUser() {
        userMediatorLiveData.setValue(new User(11, "我是UserModel中构造出来的user"));
        return userMediatorLiveData;
    }

    public void setUserObservableField(User user) {
        userObservableField.set(user);
    }

    public UserModel(@NonNull Application application) {
        super(application);
    }

    /**
     * A creator is used to inject the product ID into the ViewModel
     * <p>
     * This creator is to showcase how to inject dependencies into ViewModels. It's not
     * actually necessary in this case, as the product ID can be passed in a public method.
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        public Factory(@NonNull Application application) {
            mApplication = application;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new UserModel(mApplication);
        }
    }
}
