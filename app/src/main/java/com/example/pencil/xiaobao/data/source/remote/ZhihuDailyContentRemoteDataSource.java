package com.example.pencil.xiaobao.data.source.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.example.pencil.xiaobao.data.ZhihuDailyContent;
import com.example.pencil.xiaobao.data.source.datasource.ZhihuDailyContentDataSource;
import com.example.pencil.xiaobao.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZhihuDailyContentRemoteDataSource implements ZhihuDailyContentDataSource {
  @Nullable
  private static ZhihuDailyContentRemoteDataSource INSTANCE = null;

  // Prevent direct instantiation.
  private ZhihuDailyContentRemoteDataSource() {}

  public static ZhihuDailyContentRemoteDataSource getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ZhihuDailyContentRemoteDataSource();
    }
    return INSTANCE;
  }

  @Override
  public void getZhihuDailyContent(int id, @NonNull LoadZhihuDailyContentCallback callback) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(RetrofitService.ZHIHU_DAILY_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    RetrofitService.ZhihuDailyService service = retrofit.create(RetrofitService.ZhihuDailyService.class);

    service.getZhihuContent(id)
        .enqueue(new Callback<ZhihuDailyContent>() {
          @Override
          public void onResponse(Call<ZhihuDailyContent> call, Response<ZhihuDailyContent> response) {
            callback.onContentLoaded(response.body());
          }

          @Override
          public void onFailure(Call<ZhihuDailyContent> call, Throwable t) {
            callback.onDataNotAvailable();
          }
        });
  }

  @Override
  public void saveContent(@NonNull ZhihuDailyContent content) {
    // Not required for the local data source because the {@link TasksRepository} handles
    // converting from a {@code taskId} to a {@link task} using its cached data.
  }
}
