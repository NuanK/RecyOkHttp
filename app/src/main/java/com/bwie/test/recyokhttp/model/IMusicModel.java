package com.bwie.test.recyokhttp.model;


import com.bwie.test.recyokhttp.bean.MusicBean;
import com.bwie.test.recyokhttp.net.OnNetListener;

/**
 * Created by ASUS on 2017/11/10.
 */

public interface IMusicModel {
    public void getMusic(String offset, final OnNetListener<MusicBean> onNetListener);
}
