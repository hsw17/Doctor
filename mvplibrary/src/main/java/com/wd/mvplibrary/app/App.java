package com.wd.mvplibrary.app;

import android.app.Application;
import android.content.Context;
import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {
    //全局上下文
    public static Context context;
    private static App sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        sContext = this;
        Fresco.initialize(this);
    }


    public static App getAppContext() {
        return sContext;
    }
}
