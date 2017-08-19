package example.com.testapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private FullScreen fullScreen;

    private ScreenTransition screenTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        fullScreen = new FullScreen(this);
        fullScreen.startFullScreen();

        screenTransition = new ScreenTransition(this);

        screenTransition.moveScreen("OpeningFragment");
    }
}
