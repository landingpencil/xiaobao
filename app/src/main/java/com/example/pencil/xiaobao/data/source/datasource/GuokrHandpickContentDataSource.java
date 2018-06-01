package com.example.pencil.xiaobao.data.source.datasource;

import android.support.annotation.NonNull;
import com.example.pencil.xiaobao.data.GuokrHandpickContentResult;

public interface GuokrHandpickContentDataSource {


  interface LoadGuokrHandpickContentCallback {

    void onContentLoaded(@NonNull GuokrHandpickContentResult content);

    void onDataNotAvailable();

  }

  void getGuokrHandpickContent(int id, @NonNull LoadGuokrHandpickContentCallback callback);

  void saveContent(@NonNull GuokrHandpickContentResult content);

}
