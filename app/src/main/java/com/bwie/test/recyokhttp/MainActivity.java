package com.bwie.test.recyokhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.test.recyokhttp.adapter.MusicAdapter;
import com.bwie.test.recyokhttp.bean.MusicBean;
import com.bwie.test.recyokhttp.presenter.MusicPresenter;
import com.bwie.test.recyokhttp.view.IMainActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivity{
    private MusicPresenter musicPresenter;
    private int offset;
    private ImageView mIv;
    private ImageView mIvTitle;
    private TextView mTvTitle;
    private TextView mTvTime;
    private TextView mTvContent;
    private RecyclerView mRv;
    private LinearLayout mActivityMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        musicPresenter=new MusicPresenter(this);
        //一进页面就请求数据
        musicPresenter.getMusic(offset + "");
        mRv.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mIvTitle = (ImageView) findViewById(R.id.iv_title);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
    }

    @Override
    public void showTitleIv(String imgUrl) {
        ImageLoader.getInstance().displayImage(imgUrl,mIvTitle);

    }

    @Override
    public void showRv(List<MusicBean.SongListBean> list) {
        MusicAdapter adapter=new MusicAdapter(this,list);
        mRv.setAdapter(adapter);
    }
}
