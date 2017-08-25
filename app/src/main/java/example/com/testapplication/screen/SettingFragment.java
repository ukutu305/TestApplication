package example.com.testapplication.screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import example.com.testapplication.R;
import example.com.testapplication.data.DataEnum;

/**
 * 設定画面フラグメントのクラス
 * Created by masaki on 2017/08/20.
 */
public class SettingFragment extends ScreenFragment {

    private TextView textView;

    private View.OnClickListener onClickListenerSet = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getFacadeData().putInt(DataEnum.LEVEL, 99);
            getFacadeData().putString(DataEnum.NAME, "ああああ");
            getFacadeData().putBoolean(DataEnum.IS_CONTINUE, true);
            showSettingTextView();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.setting, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.setting_textview_settings);
        view.findViewById(R.id.setting_button_set).setOnClickListener(onClickListenerSet);
    }

    @Override
    public void onResume() {
        super.onResume();
        showSettingTextView();
    }

    private void showSettingTextView() {
        int level = getFacadeData().getInt(DataEnum.LEVEL);
        String name = getFacadeData().getString(DataEnum.NAME);
        boolean isContinue = getFacadeData().getBoolean(DataEnum.IS_CONTINUE);
        textView.setText("level = " + level + "\n"
                + "name = " + name + "\n"
                + "isContinue = " + isContinue);

    }
}
