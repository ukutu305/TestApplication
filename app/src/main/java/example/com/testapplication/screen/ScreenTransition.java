package example.com.testapplication.screen;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;

import example.com.testapplication.R;

/**
 * 画面遷移のクラス
 * Created by ukutu305 on 2017/08/19.
 */
public class ScreenTransition implements ScreenControl {

    private FragmentManager fragmentManager;

    private Map<String, ScreenFragment> map = new HashMap<>();

    private OpeningFragment openingFragment = new OpeningFragment();

    private StartFragment startFragment = new StartFragment();

    private IntroductionFragment introductionFragment = new IntroductionFragment();

    private MenuFragment menuFragment = new MenuFragment();

    private SettingFragment settingFragment = new SettingFragment();

    private String key;

    private Activity activity;

    public ScreenTransition(Activity activity) {

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
    public void show(String key) {
        if (!map.containsKey(key))
            return;

        if (this.key == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container, map.get(key));
            fragmentTransaction.commit();
            this.key = key;
        } else if (!key.equals(this.key)) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, map.get(key));
            fragmentTransaction.commit();
            this.key = key;
        }
    }

    @Override
    public void clear() {
        if (key == null)
            return;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(map.get(key));
        fragmentTransaction.commit();
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void clearKey() {
        key = null;
    }
}
