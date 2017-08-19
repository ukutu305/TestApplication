package example.com.testapplication;

import android.app.Fragment;

/**
 * 画面フラグメントのクラス
 * Created by ukutu305 on 2017/08/19.
 */
public class ScreenFragment extends Fragment {

    private ScreenTransition screenTransition;

    public ScreenTransition getScreenTransition() {
        return screenTransition;
    }

    public void setScreenTransition(ScreenTransition screenTransition) {
        this.screenTransition = screenTransition;
    }
}
