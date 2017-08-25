package example.com.testapplication.screen;

import android.app.Fragment;

import example.com.testapplication.data.FacadeData;

/**
 * 画面フラグメントのクラス
 * Created by ukutu305 on 2017/08/19.
 */
public class ScreenFragment extends Fragment {

    private ScreenTransition screenTransition;

    private FacadeData facadeData;

    public ScreenTransition getScreenTransition() {
        return screenTransition;
    }

    public void setScreenTransition(ScreenTransition screenTransition) {
        this.screenTransition = screenTransition;
    }

    public FacadeData getFacadeData() {
        return facadeData;
    }

    public void setFacadeData(FacadeData facadeData) {
        this.facadeData = facadeData;
    }
}
