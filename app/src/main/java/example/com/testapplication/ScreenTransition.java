package example.com.testapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;

/**
 * 画面遷移のクラス
 * Created by ukutu305 on 2017/08/19.
 */
class ScreenTransition implements MoveScreen {

    private FragmentManager fragmentManager;

    private Map<String, ScreenFragment> map = new HashMap<>();

    private OpeningFragment openingFragment = new OpeningFragment();

    private StartFragment startFragment = new StartFragment();

    private IntroductionFragment introductionFragment = new IntroductionFragment();

    private MenuFragment menuFragment = new MenuFragment();

    private SettingFragment settingFragment = new SettingFragment();

    private String simpleClassName;

    private Activity activity;

    ScreenTransition(Activity activity) {

        putMapFragment(openingFragment);
        putMapFragment(startFragment);
        putMapFragment(introductionFragment);
        putMapFragment(menuFragment);
        putMapFragment(settingFragment);

        this.activity = activity;

        fragmentManager = activity.getFragmentManager();

        initializeScreenFragments();
    }

    private void putMapFragment(ScreenFragment screenFragment) {
        map.put(screenFragment.getClass().getSimpleName(), screenFragment);
    }

    private void initializeScreenFragments() {
        for (String key : map.keySet()) {
            ScreenFragment screenFragment = map.get(key);
            screenFragment.setScreenTransition(this);
        }
    }

    @Override
    public void moveScreen(String simpleClassName) {
        if (!map.containsKey(simpleClassName))
            return;

        if (this.simpleClassName == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container, map.get(simpleClassName));
            fragmentTransaction.commit();
            this.simpleClassName = simpleClassName;
        } else if (!simpleClassName.equals(this.simpleClassName)) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, map.get(simpleClassName));
            fragmentTransaction.commit();
            this.simpleClassName = simpleClassName;
        }
    }
}
