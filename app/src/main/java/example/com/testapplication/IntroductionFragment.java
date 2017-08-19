package example.com.testapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * イントロダクション画面フラグメントのクラス
 * Created by ukutu305 on 2017/08/19.
 */
public class IntroductionFragment extends ScreenFragment {

    Runnable moveScreenMenuRunnable = new Runnable() {
        @Override
        public void run() {
            getScreenTransition().moveScreen("MenuFragment");
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.introduction, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        moveScreenMenu();
    }

    private void moveScreenMenu() {
        Handler handler = new Handler();
        handler.postDelayed(moveScreenMenuRunnable, 5000);
    }
}
