package example.com.testapplication;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.view.View;

/**
 * アプリケーションをフルスクリーン表示にするクラス
 * Created by ukutu305 on 2017/08/07.
 */
class FullScreen {

    private final Handler handler;

    private final View view;

    private final int visibility;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (view != null) {
                view.setSystemUiVisibility(visibility);
            }
        }
    };

    FullScreen(Handler handler, View view) {
        this.handler = handler;
        this.view = view;
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

    void startFullScreen() {
        if (handler != null) {
            handler.post(runnable);
        }
    }

    void startFullScreen(int nowVisibility) {
        if ((nowVisibility != visibility)
                && (handler != null)
                && (visibility != 0)) {
            handler.post(runnable);
        }
    }
}
