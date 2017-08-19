package example.com.testapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * オープニング画面フラグメントのクラス
 * Created by ukutu305 on 2017/08/19.
 */
public class OpeningFragment extends ScreenFragment {

    private Runnable moveScreenStartRunnable = new Runnable() {
        @Override
        public void run() {
            getScreenTransition().moveScreen("StartFragment");
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.opening, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        moveScreenStart();
    }

    private void moveScreenStart() {
        Handler handler = new Handler();
        handler.postDelayed(moveScreenStartRunnable, 5000);
    }
}
