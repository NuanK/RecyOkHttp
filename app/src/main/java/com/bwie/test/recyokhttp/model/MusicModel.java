package com.bwie.test.recyokhttp.model;

import android.os.Handler;
import android.os.Looper;


import com.bwie.test.recyokhttp.bean.MusicBean;
import com.bwie.test.recyokhttp.net.Api;
import com.bwie.test.recyokhttp.net.HttpUtils;
import com.bwie.test.recyokhttp.net.OnNetListener;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ASUS on 2017/11/10.
 */

public class MusicModel implements IMusicModel {
    private Handler handler=new Handler(Looper.myLooper());

    @Override
    public void getMusic(String offset, final OnNetListener<MusicBean> onNetListener) {
        final String url = String.format(Api.url, offset);
        HttpUtils.getHttpUtils().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                String string=response.body().string();
                final MusicBean musicBean=new Gson().fromJson(string,MusicBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(musicBean);
                    }
                });
            }
        });
    }


     /* @Override
    public void getMusic(String offset, final OnNetListener<MusicBean> onNetListener) {
        Map<String, String> params = new HashMap<>();
        params.put("method", "baidu.ting.billboard.billList");
        params.put("type", "1");
        params.put("size", "10");
        params.put("offset", offset);
        HttpUtils.getHttpUtils().doPost(Api.url, params, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final MusicBean musicBean = new Gson().fromJson(string, MusicBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(musicBean);
                    }
                });
            }
        });
    }*/
}
