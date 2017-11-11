package com.bwie.test.recyokhttp.app;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by ASUS on 2017/11/10.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration=
                new ImageLoaderConfiguration.Builder(this).build();

        ImageLoader.getInstance().init(configuration);

    }
}
