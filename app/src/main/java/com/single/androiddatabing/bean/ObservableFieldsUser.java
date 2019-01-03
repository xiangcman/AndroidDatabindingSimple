package com.single.androiddatabing.bean;

import android.databinding.ObservableField;

/**
 * Created by xiangcheng on 18/2/2.
 * 采用ObservableFields的方式也可以实现了
 */

public class ObservableFieldsUser {
    public ObservableField<String> firstName = new ObservableField<>();
    public ObservableField<String> lastName = new ObservableField<>();

    public ObservableFieldsUser(String firstName, String lastName) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
    }
}
