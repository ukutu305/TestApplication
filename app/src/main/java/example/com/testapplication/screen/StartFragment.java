package example.com.testapplication.screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.testapplication.R;

/**
 * スタート画面フラグメントのクラス
 * Created by ukutu305 on 2017/08/08.
 */
public class StartFragment extends ScreenFragment {

    private View.OnClickListener onClickListenerContinue = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getScreenTransition().show(ScreenFragmentEnum.MENU.getKey());
        }
    };

    private View.OnClickListener onClickListenerNewGame = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getScreenTransition().show(ScreenFragmentEnum.INTRODUCTION.getKey());
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.start, container, false);

        view.findViewById(R.id.start_button_continue).setOnClickListener(onClickListenerContinue);
        view.findViewById(R.id.start_button_new_game).setOnClickListener(onClickListenerNewGame);

        return view;
    }
}
