package com.example.pencil.xiaobao;

import android.app.Application;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatDelegate;

public class PaperPlaneApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    if (PreferenceManager
        .getDefaultSharedPreferences(getApplicationContext()).getBoolean("night_mode", false)) {
      AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    } else {
      AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
  }
}
