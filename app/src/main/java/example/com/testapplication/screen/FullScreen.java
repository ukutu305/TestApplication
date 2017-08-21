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

    private final View view;

    private final int visibility;

    public FullScreen(Activity activity) {
        this.view = activity.getWindow().getDecorView();
        int apiInt = Build.VERSION.SDK_INT;
        if (apiInt >= Build.VERSION_CODES.KITKAT) {
            visibility = getVisibilityKitkat();
        } else if (apiInt >= Build.VERSION_CODES.JELLY_BEAN) {
            visibility = getVisibilityJellyBean();
        } else {
            visibility = 0;
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private int getVisibilityKitkat() {
        return View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private int getVisibilityJellyBean() {
        return View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    public void startFullScreen() {
        if (view != null) {
            view.setSystemUiVisibility(visibility);
        }
    }

    public void startFullScreen(int nowVisibility) {
        if ((nowVisibility != visibility)
                && (view != null)) {
            view.setSystemUiVisibility(visibility);
        }
    }
}
