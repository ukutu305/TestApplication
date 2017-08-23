package example.com.testapplication.screen;

/**
 * 画面制御のインターフェース
 * Created by ukutu305 on 2017/08/19.
 */
interface ScreenControl {

    void show(String key);

    void clear();

    String getKey();
}
