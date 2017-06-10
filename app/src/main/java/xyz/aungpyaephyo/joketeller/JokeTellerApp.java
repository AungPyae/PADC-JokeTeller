package xyz.aungpyaephyo.joketeller;

import android.app.Application;
import android.content.Context;

/**
 * Created by aung on 6/24/16.
 */
public class JokeTellerApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static Context getContext() {
        return context;
    }

}
