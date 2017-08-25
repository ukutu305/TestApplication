package example.com.testapplication.data;

import android.app.Activity;

/**
 * データアクセスの窓口となるクラス
 * Created by ukutu305 on 2017/08/25.
 */
public class FacadeData implements DataAccess {

    private SharedPreferenceData sharedPreferenceData;

    public FacadeData(Activity activity) {
        sharedPreferenceData = new SharedPreferenceData(activity);
    }

    @Override
    public int getInt(DataEnum dataEnum) {
        return sharedPreferenceData.getInt(dataEnum);
    }

    @Override
    public void putInt(DataEnum dataEnum, int value) {
        sharedPreferenceData.putInt(dataEnum, value);
    }

    @Override
    public String getString(DataEnum dataEnum) {
        return sharedPreferenceData.getString(dataEnum);
    }

    @Override
    public void putString(DataEnum dataEnum, String value) {
        sharedPreferenceData.putString(dataEnum, value);
    }

    @Override
    public boolean getBoolean(DataEnum dataEnum) {
        return sharedPreferenceData.getBoolean(dataEnum);
    }

    @Override
    public void putBoolean(DataEnum dataEnum, boolean value) {
        sharedPreferenceData.putBoolean(dataEnum, value);
    }
}
