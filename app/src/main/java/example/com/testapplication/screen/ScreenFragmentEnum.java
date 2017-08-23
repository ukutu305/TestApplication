package example.com.testapplication.screen;

/**
 * 画面フラグメントのenumクラス
 * Created by ukutu305 on 2017/08/24.
 */
public enum ScreenFragmentEnum {

    OPENING(new OpeningFragment()),
    START(new StartFragment()),
    INTRODUCTION(new IntroductionFragment()),
    MENU(new MenuFragment()),
    SETTING(new SettingFragment()),;

    private ScreenFragment screenFragment;

    private String key;

    ScreenFragmentEnum(ScreenFragment screenFragment) {
        this.screenFragment = screenFragment;
        key = screenFragment.getClass().getSimpleName();
    }

    public ScreenFragment getScreenFragment() {
        return screenFragment;
    }

    public String getKey() {
        return key;
    }
}
