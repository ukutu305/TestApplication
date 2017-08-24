package example.com.testapplication.screen;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;

/**
 * アプリケーションをフルスクリーン表示にするクラス
 * Created by ukutu305 on 2017/08/07.
 */
public class FullScreen {

    public static void start(Activity activity) {
        View view = activity.getWindow().getDecorView();
        int apiInt = Build.VERSION.SDK_INT;
        int visibility;
        if (apiInt >= Build.VERSION_CODES.KITKAT) {
            visibility = getVisibilityKitkat();
        } else if (apiInt >= Build.VERSION_CODES.JELLY_BEAN) {
            visibility = getVisibilityJellyBean();
        } else {
            visibility = 0;
        }
        view.setSystemUiVisibility(visibility);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private static int getVisibilityKitkat() {
        return View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private static int getVisibilityJellyBean() {
        return View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }
}
