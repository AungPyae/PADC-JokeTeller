package xyz.aungpyaephyo.joketeller;

import android.app.Application;

import xyz.aungpyaephyo.joketeller.utils.MMFontUtils;

/**
 * Created by aung on 6/24/16.
 */
public class JokeTellerApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MMFontUtils.initMMFontUtils(getApplicationContext());
    }

}
