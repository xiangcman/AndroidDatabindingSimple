package com.single.androiddatabing.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.single.androiddatabing.BR;

/**
 * Created by xiangcheng on 19/1/3.
 */

public class ObservableBean extends BaseObservable {
    private String firstName;
    private String lastName;

    public ObservableBean(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return this.firstName;
    }

    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

}
