package com.example.pencil.xiaobao.data.source.local;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.example.pencil.xiaobao.data.GuokrHandpickNewsResult;
import com.example.pencil.xiaobao.data.source.datasource.GuokrHandpickDataSource;
import com.example.pencil.xiaobao.database.AppDatabase;
import com.example.pencil.xiaobao.database.DatabaseCreator;
import java.util.List;

public class GuokrHandpickNewsLocalDataSource implements GuokrHandpickDataSource {
  @Nullable
  private static GuokrHandpickNewsLocalDataSource INSTANCE = null;

  @Nullable
  private AppDatabase mDb = null;

  private GuokrHandpickNewsLocalDataSource(@NonNull Context context) {
    DatabaseCreator creator = DatabaseCreator.getInstance();
    if (!creator.isDatabaseCreated()) {
      creator.createDb(context);
    }
    mDb = creator.getDatabase();
  }

  public static GuokrHandpickNewsLocalDataSource getInstance(@NonNull Context context) {
    if (INSTANCE == null) {
      INSTANCE = new GuokrHandpickNewsLocalDataSource(context);
    }
    return INSTANCE;
  }

  @Override
  public void getGuokrHandpickNews(boolean forceUpdate, boolean clearCache, int offset, int limit, @NonNull LoadGuokrHandpickNewsCallback callback) {
    if (mDb == null) {
      mDb = DatabaseCreator.getInstance().getDatabase();
    }

    if (mDb != null) {
      new AsyncTask<Void, Void, List<GuokrHandpickNewsResult>>() {

        @Override
        protected List<GuokrHandpickNewsResult> doInBackground(Void... voids) {
          return mDb.guokrHandpickNewsDao().queryAllByOffsetAndLimit(offset, limit);
        }

        @Override
        protected void onPostExecute(List<GuokrHandpickNewsResult> list) {
          super.onPostExecute(list);
          if (list == null) {
            callback.onDataNotAvailable();
          } else {
            callback.onNewsLoad(list);
          }
        }
      }.execute();
    }
  }

  @Override
  public void getFavorites(@NonNull LoadGuokrHandpickNewsCallback callback) {
    if (mDb == null) {
      mDb = DatabaseCreator.getInstance().getDatabase();
    }

    if (mDb != null) {
      new AsyncTask<Void, Void, List<GuokrHandpickNewsResult>>() {

        @Override
        protected List<GuokrHandpickNewsResult> doInBackground(Void... voids) {
          return mDb.guokrHandpickNewsDao().queryAllFavorites();
        }

        @Override
        protected void onPostExecute(List<GuokrHandpickNewsResult> list) {
          super.onPostExecute(list);
          if (list == null) {
            callback.onDataNotAvailable();
          } else {
            callback.onNewsLoad(list);
          }
        }
      }.execute();
    }
  }

  @Override
  public void getItem(int itemId, @NonNull GetNewsItemCallback callback) {
    if (mDb == null) {
      mDb = DatabaseCreator.getInstance().getDatabase();
    }

    if (mDb != null) {
      new AsyncTask<Void, Void, GuokrHandpickNewsResult>() {

        @Override
        protected GuokrHandpickNewsResult doInBackground(Void... voids) {
          return mDb.guokrHandpickNewsDao().queryItemById(itemId);
        }

        @Override
        protected void onPostExecute(GuokrHandpickNewsResult item) {
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
        GuokrHandpickNewsResult tmp = mDb.guokrHandpickNewsDao().queryItemById(itemId);
        if (tmp != null) {
          tmp.setFavorite(favorite);
          mDb.guokrHandpickNewsDao().update(tmp);
        }
      }).start();
    }
  }

  @Override
  public void saveAll(@NonNull List<GuokrHandpickNewsResult> list) {
    if (mDb == null) {
      mDb = DatabaseCreator.getInstance().getDatabase();
    }

    if (mDb != null) {
      new Thread(() -> {
        mDb.beginTransaction();
        try {
          mDb.guokrHandpickNewsDao().insertAll(list);
          mDb.setTransactionSuccessful();
        } finally {
          mDb.endTransaction();
        }
      }).start();
    }
  }
}
