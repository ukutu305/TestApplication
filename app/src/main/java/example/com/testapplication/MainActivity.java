package example.com.testapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import example.com.testapplication.screen.FullScreen;
import example.com.testapplication.screen.ScreenTransition;

public class MainActivity extends AppCompatActivity {

    private FullScreen fullScreen;

    private ScreenTransition screenTransition;

    private String screenKeySaveInstanceState;

    private String screenKeyOnPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
        if (fullScreen == null)
            fullScreen = new FullScreen(this);

        fullScreen.startFullScreen();

        if (screenTransition == null)
            screenTransition = new ScreenTransition(this);

        if (screenKeySaveInstanceState != null) {
            screenTransition.show(screenKeySaveInstanceState);
        } else if (screenKeyOnPause != null) {
            screenTransition.show(screenKeyOnPause);
        } else {
            screenTransition.show("OpeningFragment");
        }
        screenKeySaveInstanceState = null;
        screenKeyOnPause = null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (screenTransition != null) {
            screenKeyOnPause = screenTransition.getKey();
            screenTransition.clear();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (screenTransition != null)
            outState.putString("screenKeySaveInstanceState", screenTransition.getKey());

    }

    @Override
    protected void onStop() {
        super.onStop();
        screenTransition = null;
    }
}
