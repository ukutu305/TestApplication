package example.com.testapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import example.com.testapplication.data.FacadeData;
import example.com.testapplication.screen.FullScreen;
import example.com.testapplication.screen.ScreenTransition;

public class MainActivity extends AppCompatActivity {

    private ScreenTransition screenTransition;

    private String screenKeySaveInstanceState;

    private String screenKeyOnPause;

    private FacadeData facadeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        facadeData = new FacadeData(this);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            screenKeySaveInstanceState = savedInstanceState.getString("screenKeySaveInstanceState");
        } else {
            screenKeySaveInstanceState = null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        FullScreen.start(this);

        screenTransition = new ScreenTransition(this, facadeData);
        screenTransition.showOnResume(screenKeySaveInstanceState, screenKeyOnPause);
        screenKeySaveInstanceState = null;
        screenKeyOnPause = null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        screenKeyOnPause = screenTransition.getKey();
        screenTransition.clear();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("screenKeySaveInstanceState", screenTransition.getKey());

    }

    @Override
    protected void onStop() {
        super.onStop();
        screenTransition = null;
    }
}
