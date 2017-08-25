package example.com.testapplication.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferencesデータのクラス
 * Created by ukutu305 on 2017/08/25.
 */
class SharedPreferenceData implements DataAccess {

    private SharedPreferences sharedPreferences;

    SharedPreferenceData(Activity activity) {
        sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
    }

    @Override
    public int getInt(DataEnum dataEnum) {
        return sharedPreferences.getInt(dataEnum.getKey(), DataAccess.defaultValueInt);
    }

    @Override
    public void putInt(DataEnum dataEnum, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(dataEnum.getKey(), value);
        editor.apply();
    }

    @Override
    public String getString(DataEnum dataEnum) {
        return sharedPreferences.getString(dataEnum.getKey(), DataAccess.defaultValueString);
    }

    @Override
    public void putString(DataEnum dataEnum, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(dataEnum.getKey(), value);
        editor.apply();
    }

    @Override
    public boolean getBoolean(DataEnum dataEnum) {
        return sharedPreferences.getBoolean(dataEnum.getKey(), DataAccess.defaultValueBoolean);
    }

    @Override
    public void putBoolean(DataEnum dataEnum, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(dataEnum.getKey(), value);
        editor.apply();
    }
}
