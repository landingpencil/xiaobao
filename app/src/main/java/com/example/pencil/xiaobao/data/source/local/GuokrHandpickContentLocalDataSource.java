package com.example.pencil.xiaobao.data.source.local;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.example.pencil.xiaobao.data.GuokrHandpickContentResult;
import com.example.pencil.xiaobao.data.source.datasource.GuokrHandpickContentDataSource;
import com.example.pencil.xiaobao.database.AppDatabase;
import com.example.pencil.xiaobao.database.DatabaseCreator;

public class GuokrHandpickContentLocalDataSource implements GuokrHandpickContentDataSource {
  @Nullable
  private static GuokrHandpickContentLocalDataSource INSTANCE = null;

  @Nullable
  private AppDatabase mDb = null;

  private GuokrHandpickContentLocalDataSource(@NonNull Context context) {
    DatabaseCreator creator = DatabaseCreator.getInstance();
    if (!creator.isDatabaseCreated()) {
      creator.createDb(context);
    }
    mDb = creator.getDatabase();
  }

  public static GuokrHandpickContentLocalDataSource getInstance(@NonNull Context context) {
    if (INSTANCE == null) {
      INSTANCE = new GuokrHandpickContentLocalDataSource(context);
    }
    return INSTANCE;
  }

  public static void destroyInstance() {
    INSTANCE = null;
  }

  @Override
  public void getGuokrHandpickContent(int id, @NonNull LoadGuokrHandpickContentCallback callback) {
    if (mDb == null) {
      callback.onDataNotAvailable();
      return;
    }

    new AsyncTask<Void, Void, GuokrHandpickContentResult>() {

      @Override
      protected GuokrHandpickContentResult doInBackground(Void... voids) {
        return mDb.guokrHandpickContentDao().queryContentById(id);
      }

      @Override
      protected void onPostExecute(GuokrHandpickContentResult content) {
        super.onPostExecute(content);
        if (content == null) {
          callback.onDataNotAvailable();
        } else {
          callback.onContentLoaded(content);
        }
      }
    }.execute();
  }

  @Override
  public void saveContent(@NonNull GuokrHandpickContentResult content) {
    if (mDb != null) {
      new Thread(() -> {
        mDb.beginTransaction();
        try {
          mDb.guokrHandpickContentDao().insert(content);
          mDb.setTransactionSuccessful();
        } finally {
          mDb.endTransaction();
        }
      }).start();
    }
  }
}
