package com.example.pencil.xiaobao.data.source.datasource;

import android.support.annotation.NonNull;
import com.example.pencil.xiaobao.data.ZhihuDailyContent;

public interface ZhihuDailyContentDataSource {

  interface LoadZhihuDailyContentCallback {

    void onContentLoaded(@NonNull ZhihuDailyContent content);

    void onDataNotAvailable();

  }

  void getZhihuDailyContent(int id, @NonNull LoadZhihuDailyContentCallback callback);

  void saveContent(@NonNull ZhihuDailyContent content);

}

