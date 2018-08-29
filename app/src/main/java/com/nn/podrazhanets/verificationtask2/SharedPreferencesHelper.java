package com.nn.podrazhanets.verificationtask2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    private static final String SHARED_PREFERENCES_NAME = "SETTINGS_SHARED_PREF";
    private static final String SEARCH_SYSTEM = "SEARCH_SYSTEM";

    private SharedPreferences mSharedPreferences;

    SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public int getSearchSystem() {
        return mSharedPreferences.getInt(SEARCH_SYSTEM, R.id.radioButtonGoogle);
    }

    public void setSearchSystem(int idSearchSystem) {
        mSharedPreferences.edit().putInt(SEARCH_SYSTEM, idSearchSystem).apply();
    }
}
