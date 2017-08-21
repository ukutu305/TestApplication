package example.com.testapplication.screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.testapplication.R;

/**
 * メニュー画面フラグメントのクラス
 * Created by ukutu305 on 2017/08/19.
 */
public class MenuFragment extends ScreenFragment {

    private View.OnClickListener onClickListenerSettings = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getScreenTransition().show("SettingFragment");
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.menu, container, false);

        view.findViewById(R.id.menu_button_settings).setOnClickListener(onClickListenerSettings);

        return view;
    }
}
