package example.com.testapplication.screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.testapplication.R;

/**
 * 設定画面フラグメントのクラス
 * Created by masaki on 2017/08/20.
 */
public class SettingFragment extends ScreenFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.setting, container, false);
    }
}
