package com.example.pencil.xiaobao.customtabs;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;
import com.example.pencil.xiaobao.R;
import com.example.pencil.xiaobao.util.InfoConstants;

public class CustomTabsHelper {

  public static void openUrl(Context context, String url) {
    SharedPreferences sharedPreferences = PreferenceManager
        .getDefaultSharedPreferences(context);

    if (sharedPreferences.getBoolean(InfoConstants.KEY_CHROME_CUSTOM_TABS, true)) {
      CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
      builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
      builder.build().launchUrl(context, Uri.parse(url));
    } else {
      try {
        context.startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)));
      } catch (ActivityNotFoundException e) {
        Toast.makeText(context, R.string.no_brower_found, Toast.LENGTH_SHORT).show();
      }
    }
  }

}
