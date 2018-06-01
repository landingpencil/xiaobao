package com.example.pencil.xiaobao.data.source.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.example.pencil.xiaobao.data.DoubanMomentNewsPosts;
import com.example.pencil.xiaobao.data.source.datasource.DoubanMomentNewsDataSource;
import com.example.pencil.xiaobao.util.DateFormatUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DoubanMomentNewsRepository implements DoubanMomentNewsDataSource {
  @Nullable
  private static DoubanMomentNewsRepository INSTANCE = null;

  @NonNull
  private final DoubanMomentNewsDataSource mLocalDataSource;

  @NonNull
  private final DoubanMomentNewsDataSource mRemoteDataSource;

  private Map<Integer, DoubanMomentNewsPosts> mCachedItems;

  private DoubanMomentNewsRepository(@NonNull DoubanMomentNewsDataSource remoteDataSource,
      @NonNull DoubanMomentNewsDataSource localDataSource) {
    this.mLocalDataSource = localDataSource;
    this.mRemoteDataSource = remoteDataSource;
  }

  public static DoubanMomentNewsRepository getInstance(@NonNull DoubanMomentNewsDataSource remoteDataSource,
      @NonNull DoubanMomentNewsDataSource localDataSource) {
    if (INSTANCE == null) {
      INSTANCE = new DoubanMomentNewsRepository(remoteDataSource, localDataSource);
    }
    return INSTANCE;
  }

  public static void destroyInstance() {
    INSTANCE = null;
  }

  @Override
  public void getDoubanMomentNews(boolean forceUpdate, boolean clearCache, long date, @NonNull LoadDoubanMomentDailyCallback callback) {

    if (mCachedItems != null && !forceUpdate) {
      callback.onNewsLoaded(new ArrayList<>(mCachedItems.values()));
      return;
    }

    mRemoteDataSource.getDoubanMomentNews(false, clearCache, date, new LoadDoubanMomentDailyCallback() {
      @Override
      public void onNewsLoaded(@NonNull List<DoubanMomentNewsPosts> list) {
        refreshCache(clearCache, list);
        callback.onNewsLoaded(new ArrayList<>(mCachedItems.values()));

        saveAll(list);
      }

      @Override
      public void onDataNotAvailable() {
        mLocalDataSource.getDoubanMomentNews(false, clearCache, date, new LoadDoubanMomentDailyCallback() {
          @Override
          public void onNewsLoaded(@NonNull List<DoubanMomentNewsPosts> list) {
            refreshCache(clearCache, list);
            callback.onNewsLoaded(new ArrayList<>(mCachedItems.values()));
          }

          @Override
          public void onDataNotAvailable() {
            callback.onDataNotAvailable();
          }
        });
      }
    });

  }

  @Override
  public void getFavorites(@NonNull LoadDoubanMomentDailyCallback callback) {
    mLocalDataSource.getFavorites(new LoadDoubanMomentDailyCallback() {
      @Override
      public void onNewsLoaded(@NonNull List<DoubanMomentNewsPosts> list) {
        callback.onNewsLoaded(list);
      }

      @Override
      public void onDataNotAvailable() {
        callback.onDataNotAvailable();
      }
    });
  }

  @Override
  public void getItem(int id, @NonNull GetNewsItemCallback callback) {
    DoubanMomentNewsPosts cachedItem = getItemWithId(id);

    if (cachedItem != null) {
      callback.onItemLoaded(cachedItem);
      return;
    }

    mLocalDataSource.getItem(id, new GetNewsItemCallback() {
      @Override
      public void onItemLoaded(@NonNull DoubanMomentNewsPosts item) {
        if (mCachedItems == null) {
          mCachedItems = new LinkedHashMap<>();
        }
        mCachedItems.put(item.getId(), item);
        callback.onItemLoaded(item);
      }

      @Override
      public void onDataNotAvailable() {
        mRemoteDataSource.getItem(id, new GetNewsItemCallback() {
          @Override
          public void onItemLoaded(@NonNull DoubanMomentNewsPosts item) {
            if (mCachedItems == null) {
              mCachedItems = new LinkedHashMap<>();
            }
            mCachedItems.put(item.getId(), item);
            callback.onItemLoaded(item);
          }

          @Override
          public void onDataNotAvailable() {
            callback.onDataNotAvailable();
          }
        });
      }
    });
  }

  @Override
  public void favoriteItem(int itemId, boolean favorite) {
    mRemoteDataSource.favoriteItem(itemId, favorite);
    mLocalDataSource.favoriteItem(itemId, favorite);

    DoubanMomentNewsPosts cachedItem = getItemWithId(itemId);
    if (cachedItem != null) {
      cachedItem.setFavorite(favorite);
    }
  }

  @Override
  public void saveAll(@NonNull List<DoubanMomentNewsPosts> list) {
    for (DoubanMomentNewsPosts item : list) {
      // Set the timestamp.
      item.setTimestamp(DateFormatUtil.formatDoubanMomentDateStringToLong(item.getPublishedTime()));
      mCachedItems.put(item.getId(), item);
    }

    mLocalDataSource.saveAll(list);
    mRemoteDataSource.saveAll(list);

    if (mCachedItems == null) {
      mCachedItems = new LinkedHashMap<>();
    }
  }

  private void refreshCache(boolean clearCache, List<DoubanMomentNewsPosts> list) {

    if (mCachedItems == null) {
      mCachedItems = new LinkedHashMap<>();
    }
    if (clearCache) {
      mCachedItems.clear();
    }
    for (DoubanMomentNewsPosts item : list) {
      mCachedItems.put(item.getId(), item);
    }
  }

  @Nullable
  private DoubanMomentNewsPosts getItemWithId(int id) {
    return (mCachedItems == null || mCachedItems.isEmpty()) ? null : mCachedItems.get(id);
  }
}
