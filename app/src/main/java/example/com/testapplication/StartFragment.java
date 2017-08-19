package example.com.testapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * スタート画面フラグメントのクラス
 * Created by ukutu305 on 2017/08/08.
 */
public class StartFragment extends ScreenFragment {

    private View.OnClickListener onClickListenerContinue = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getScreenTransition().moveScreen("MenuFragment");
        }
    };

    private View.OnClickListener onClickListenerNewGame = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getScreenTransition().moveScreen("IntroductionFragment");
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
