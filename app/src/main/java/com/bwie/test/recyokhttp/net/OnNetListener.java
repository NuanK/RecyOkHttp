package com.bwie.test.recyokhttp.net;

/**
 * Created by ASUS on 2017/11/10.
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);

    public void onFailure(Exception e);
}
