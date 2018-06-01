package com.example.pencil.xiaobao.data.source.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.example.pencil.xiaobao.data.DoubanMomentContent;
import com.example.pencil.xiaobao.data.source.datasource.DoubanMomentContentDataSource;
import com.example.pencil.xiaobao.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DoubanMomentContentRemoteDataSource implements DoubanMomentContentDataSource {
  @Nullable
  private static DoubanMomentContentRemoteDataSource INSTANCE = null;

  // Prevent direct instantiation.
  private DoubanMomentContentRemoteDataSource() {}

  public static DoubanMomentContentRemoteDataSource getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new DoubanMomentContentRemoteDataSource();
    }
    return INSTANCE;
  }

  @Override
  public void getDoubanMomentContent(int id, @NonNull LoadDoubanMomentContentCallback callback) {

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(RetrofitService.DOUBAN_MOMENT_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    RetrofitService.DoubanMomentService service = retrofit.create(RetrofitService.DoubanMomentService.class);

    service.getDoubanContent(id).enqueue(new Callback<DoubanMomentContent>() {
      @Override
      public void onResponse(Call<DoubanMomentContent> call, Response<DoubanMomentContent> response) {
        callback.onContentLoaded(response.body());
      }

      @Override
      public void onFailure(Call<DoubanMomentContent> call, Throwable t) {
        callback.onDataNotAvailable();
      }
    });

  }

  @Override
  public void saveContent(@NonNull DoubanMomentContent content) {
    // Not required for the remote data source because the {@link TasksRepository} handles
    // converting from a {@code taskId} to a {@link task} using its cached data.
  }
}
