package com.example.pencil.xiaobao.data.source.local;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.example.pencil.xiaobao.data.DoubanMomentNewsPosts;
import com.example.pencil.xiaobao.data.source.datasource.DoubanMomentNewsDataSource;
import com.example.pencil.xiaobao.database.AppDatabase;
import com.example.pencil.xiaobao.database.DatabaseCreator;
import java.util.List;

public class DoubanMomentNewsLocalDataSource implements DoubanMomentNewsDataSource {
  @Nullable
  private static DoubanMomentNewsLocalDataSource INSTANCE = null;

  @Nullable
  private AppDatabase mDb = null;

  private DoubanMomentNewsLocalDataSource(@NonNull Context context) {
    DatabaseCreator creator = DatabaseCreator.getInstance();
    if (!creator.isDatabaseCreated()) {
      creator.createDb(context);
    }
  }

  public static DoubanMomentNewsLocalDataSource getInstance(@NonNull Context context) {
    if (INSTANCE == null) {
      INSTANCE = new DoubanMomentNewsLocalDataSource(context);
    }
    return INSTANCE;
  }

  @Override
  public void getDoubanMomentNews(boolean forceUpdate, boolean clearCache, long date, @NonNull LoadDoubanMomentDailyCallback callback) {
    if (mDb == null) {
      mDb = DatabaseCreator.getInstance().getDatabase();
    }

    if (mDb != null) {
      new AsyncTask<Void, Void, List<DoubanMomentNewsPosts>>() {

        @Override
        protected List<DoubanMomentNewsPosts> doInBackground(Void... voids) {
          return mDb.doubanMomentNewsDao().queryAllByDate(date);
        }

        @Override
        protected void onPostExecute(List<DoubanMomentNewsPosts> list) {
          super.onPostExecute(list);
          if (list == null) {
            callback.onDataNotAvailable();
          } else {
            callback.onNewsLoaded(list);
          }
        }
      }.execute();
    }
  }

  @Override
  public void getFavorites(@NonNull LoadDoubanMomentDailyCallback callback) {
    if (mDb == null) {
      mDb = DatabaseCreator.getInstance().getDatabase();
    }

    if (mDb != null) {
      new AsyncTask<Void, Void, List<DoubanMomentNewsPosts>>() {

        @Override
        protected List<DoubanMomentNewsPosts> doInBackground(Void... voids) {
          return mDb.doubanMomentNewsDao().queryAllFavorites();
        }

        @Override
        protected void onPostExecute(List<DoubanMomentNewsPosts> list) {
          super.onPostExecute(list);
          if (list == null) {
            callback.onDataNotAvailable();
          } else {
            callback.onNewsLoaded(list);
          }
        }
      }.execute();
    }
  }

  @Override
  public void getItem(int id, @NonNull GetNewsItemCallback callback) {
    if (mDb == null) {
      mDb = DatabaseCreator.getInstance().getDatabase();
    }

    if (mDb != null) {
      new AsyncTask<Void, Void, DoubanMomentNewsPosts>() {

        @Override
        protected DoubanMomentNewsPosts doInBackground(Void... voids) {
          return mDb.doubanMomentNewsDao().queryItemById(id);
        }

        @Override
        protected void onPostExecute(DoubanMomentNewsPosts item) {
          super.onPostExecute(item);
          if (item == null) {
            callback.onDataNotAvailable();
          } else {
            callback.onItemLoaded(item);
          }
        }

      }.execute();
    }
  }

  @Override
  public void favoriteItem(int itemId, boolean favorite) {
    if (mDb == null) {
      mDb = DatabaseCreator.getInstance().getDatabase();
    }

    if (mDb != null) {
      new Thread(() -> {
        DoubanMomentNewsPosts tmp = mDb.doubanMomentNewsDao().queryItemById(itemId);
        tmp.setFavorite(favorite);
        mDb.doubanMomentNewsDao().update(tmp);
      }).start();
    }
  }

  @Override
  public void saveAll(@NonNull List<DoubanMomentNewsPosts> list) {
    if (mDb == null) {
      mDb = DatabaseCreator.getInstance().getDatabase();
    }

    if (mDb != null) {
      new Thread(() -> {
        mDb.beginTransaction();
        try {
          mDb.doubanMomentNewsDao().insertAll(list);
          mDb.setTransactionSuccessful();
        } finally {
          mDb.endTransaction();
        }
      }).start();
    }
  }
}
