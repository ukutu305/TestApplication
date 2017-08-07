package example.com.testapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnSystemUiVisibilityChangeListener {

    private Handler handler = new Handler();

    private FullScreen fullScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = getWindow().getDecorView();

        view.setOnSystemUiVisibilityChangeListener(this);

        fullScreen = new FullScreen(handler, view);

        fullScreen.startFullScreen();

        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public void onSystemUiVisibilityChange(int visibility) {
        fullScreen.startFullScreen(visibility);
    }
}
