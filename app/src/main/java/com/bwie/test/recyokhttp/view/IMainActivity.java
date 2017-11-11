package com.bwie.test.recyokhttp.view;

import com.bwie.test.recyokhttp.bean.MusicBean;

import java.util.List;

/**
 * Created by ASUS on 2017/11/10.
 */

public interface IMainActivity {
    public void showTitleIv(String imgUrl);
    public void showRv(List<MusicBean.SongListBean> list);
}
