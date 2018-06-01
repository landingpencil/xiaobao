package com.example.pencil.xiaobao.data.source.datasource;

import android.support.annotation.NonNull;
import com.example.pencil.xiaobao.data.DoubanMomentContent;

public interface DoubanMomentContentDataSource {
  interface LoadDoubanMomentContentCallback {

    void onContentLoaded(@NonNull DoubanMomentContent content);

    void onDataNotAvailable();

  }

  void getDoubanMomentContent(int id, @NonNull LoadDoubanMomentContentCallback callback);

  void saveContent(@NonNull DoubanMomentContent content);
}
