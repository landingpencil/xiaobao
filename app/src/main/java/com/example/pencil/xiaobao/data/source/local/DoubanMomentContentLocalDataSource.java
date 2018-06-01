package com.example.pencil.xiaobao.data.source.local;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.example.pencil.xiaobao.data.DoubanMomentContent;
import com.example.pencil.xiaobao.data.source.datasource.DoubanMomentContentDataSource;
import com.example.pencil.xiaobao.database.AppDatabase;
import com.example.pencil.xiaobao.database.DatabaseCreator;

public class DoubanMomentContentLocalDataSource implements DoubanMomentContentDataSource {
  @Nullable
  private static DoubanMomentContentLocalDataSource INSTANCE = null;

  @Nullable
  private AppDatabase mDb = null;

  private DoubanMomentContentLocalDataSource(@NonNull Context context) {
    DatabaseCreator creator = DatabaseCreator.getInstance();
    if(!creator.isDatabaseCreated()) {
      creator.createDb(context);
    }
    mDb = creator.getDatabase();
  }

  public static DoubanMomentContentLocalDataSource getInstance(@NonNull Context context) {
    if (INSTANCE == null) {
      INSTANCE = new DoubanMomentContentLocalDataSource(context);
    }
    return INSTANCE;
  }

  @Override
  public void getDoubanMomentContent(int id, @NonNull LoadDoubanMomentContentCallback callback) {
    if (mDb == null) {
      callback.onDataNotAvailable();
      return;
    }

    new AsyncTask<Void, Void, DoubanMomentContent>() {

      @Override
      protected DoubanMomentContent doInBackground(Void... voids) {
        return mDb.doubanMomentContentDao().queryContentById(id);
      }

      @Override
      protected void onPostExecute(DoubanMomentContent content) {
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
  public void saveContent(@NonNull DoubanMomentContent content) {
    if (mDb != null) {
      new Thread(() -> {
        mDb.beginTransaction();
        try {
          mDb.doubanMomentContentDao().insert(content);
          mDb.setTransactionSuccessful();
        } finally {
          mDb.endTransaction();
        }
      }).start();
    }
  }
}
