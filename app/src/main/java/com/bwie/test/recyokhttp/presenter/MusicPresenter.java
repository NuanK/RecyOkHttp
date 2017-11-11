package com.bwie.test.recyokhttp.presenter;


import com.bwie.test.recyokhttp.bean.MusicBean;
import com.bwie.test.recyokhttp.model.MusicModel;
import com.bwie.test.recyokhttp.net.OnNetListener;
import com.bwie.test.recyokhttp.view.IMainActivity;

import java.security.PublicKey;

/**
 * Created by ASUS on 2017/11/10.
 */

public class MusicPresenter {
    private MusicModel musicModel;
    private IMainActivity iMainActivity;

    public MusicPresenter(IMainActivity iMainActivity){
        this.iMainActivity=iMainActivity;
        musicModel=new MusicModel();
    }
   public void getMusic(String offset){
       musicModel.getMusic(offset, new OnNetListener<MusicBean>() {
           @Override
           public void onSuccess(MusicBean musicBean) {
               iMainActivity.showTitleIv(musicBean.getBillboard().getPic_s640());
               iMainActivity.showRv(musicBean.getSong_list());
           }

           @Override
           public void onFailure(Exception e) {

           }
       });
   }

}
