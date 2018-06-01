package com.example.pencil.xiaobao.data.source.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.example.pencil.xiaobao.data.DoubanMomentContent;
import com.example.pencil.xiaobao.data.source.datasource.DoubanMomentContentDataSource;

public class DoubanMomentContentRepository implements DoubanMomentContentDataSource {
  @Nullable
  private static DoubanMomentContentRepository INSTANCE = null;

  @NonNull
  private final DoubanMomentContentDataSource mLocalDataSource;

  @NonNull
  private final DoubanMomentContentDataSource mRemoteDataSource;

  @Nullable
  private DoubanMomentContent mContent;

  private DoubanMomentContentRepository(@NonNull DoubanMomentContentDataSource remoteDataSource,
      @NonNull DoubanMomentContentDataSource localDataSource) {
    mLocalDataSource = localDataSource;
    mRemoteDataSource = remoteDataSource;
  }

  public static DoubanMomentContentRepository getInstance(@NonNull DoubanMomentContentDataSource remoteDataSource,
      @NonNull DoubanMomentContentDataSource localDataSource) {
    if (INSTANCE == null) {
      INSTANCE = new DoubanMomentContentRepository(remoteDataSource, localDataSource);
    }
    return INSTANCE;
  }

  public static void destroyInstance() {
    INSTANCE = null;
  }

  @Override
  public void getDoubanMomentContent(int id, @NonNull LoadDoubanMomentContentCallback callback) {
    if (mContent != null) {
      callback.onContentLoaded(mContent);
      return;
    }

    // Get data from net first.
    mRemoteDataSource.getDoubanMomentContent(id, new LoadDoubanMomentContentCallback() {
      @Override
      public void onContentLoaded(@NonNull DoubanMomentContent content) {
        if (mContent == null) {
          mContent = content;
          saveContent(content);
        }
        callback.onContentLoaded(content);
      }

      @Override
      public void onDataNotAvailable() {
        mLocalDataSource.getDoubanMomentContent(id, new LoadDoubanMomentContentCallback() {
          @Override
          public void onContentLoaded(@NonNull DoubanMomentContent content) {
            if (mContent == null) {
              mContent = content;
            }
            callback.onContentLoaded(content);
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
  public void saveContent(@NonNull DoubanMomentContent content) {
    mLocalDataSource.saveContent(content);
    mRemoteDataSource.saveContent(content);
  }
}
