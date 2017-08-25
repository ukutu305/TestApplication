package example.com.testapplication.data;

/**
 * データアクセスのインターフェース
 * Created by ukutu305 on 2017/08/25.
 */
interface DataAccess {

    int defaultValueInt = 0;
    String defaultValueString = "";
    boolean defaultValueBoolean = false;

    int getInt(DataEnum dataEnum);

    void putInt(DataEnum dataEnum, int value);

    String getString(DataEnum dataEnum);

    void putString(DataEnum dataEnum, String value);

    boolean getBoolean(DataEnum dataEnum);

    void putBoolean(DataEnum dataEnum, boolean value);

    enum TYPE {
        INT,
        STRING,
        BOOLEAN
    }
}
