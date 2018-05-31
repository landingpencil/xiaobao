package com.example.pencil.xiaobao.retrofit;

import com.example.pencil.xiaobao.data.DoubanMomentContent;
import com.example.pencil.xiaobao.data.DoubanMomentNews;
import com.example.pencil.xiaobao.data.GuokrHandpickContent;
import com.example.pencil.xiaobao.data.GuokrHandpickNews;
import com.example.pencil.xiaobao.data.ZhihuDailyContent;
import com.example.pencil.xiaobao.data.ZhihuDailyNews;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Retrofit {

  String zhihu_daily_base = "https://news-at.zhihu.com/api/4/news/";
  String DOUBAN_MONENT_BASE = "https://moment.douban.com/api/";
  String GUOKR_handpick_base = "http://apis.guokr.com/minisite/";

  interface ZhihuDailyService {

    @GET("before/{date}")
    Call<ZhihuDailyNews> getZhihuList(@Path("date") String date);

    @GET("{id}")
    Call<ZhihuDailyContent> getZhihuContent(@Path("id") int id);

  }

  interface DoubanMomentService{

    @GET("stream/date/{date}")
    Call<DoubanMomentNews> getDoubanList(@Path("date") String date);

    @GET("post/{id}")
    Call<DoubanMomentContent> getDoubanContent(@Path("id") int id);


  }

  interface GuokrHandpickService{

    @GET("article.json?retrieve_type=by_minisite")
    Call<GuokrHandpickNews> getGuokrHandpick(@Query("offset")int offset, @Query("limit")int limit );

    @GET("article/{id}.json")
    Call<GuokrHandpickContent> getGuokrContent(@Path("id")int id);
  }

}
