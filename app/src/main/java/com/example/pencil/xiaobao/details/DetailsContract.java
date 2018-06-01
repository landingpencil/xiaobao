package com.example.pencil.xiaobao.details;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import com.example.pencil.xiaobao.BasePresenter;
import com.example.pencil.xiaobao.BaseView;
import com.example.pencil.xiaobao.data.ContentType;
import com.example.pencil.xiaobao.data.DoubanMomentContent;
import com.example.pencil.xiaobao.data.DoubanMomentNewsThumbs;
import com.example.pencil.xiaobao.data.GuokrHandpickContentResult;
import com.example.pencil.xiaobao.data.ZhihuDailyContent;
import java.util.List;

public interface DetailsContract {
  interface View extends BaseView<Presenter> {

    void showMessage(@StringRes int stringRes);

    boolean isActive();

    void showZhihuDailyContent(@NonNull ZhihuDailyContent content);

    void showDoubanMomentContent(@NonNull DoubanMomentContent content, @Nullable List<DoubanMomentNewsThumbs> list);

    void showGuokrHandpickContent(@NonNull GuokrHandpickContentResult content);

    void share(@Nullable String link);

    void copyLink(@Nullable String link);

    void openWithBrowser(@Nullable String link);

  }

  interface Presenter extends BasePresenter {

    void favorite(ContentType type, int id, boolean favorite);

    void loadDoubanContent(int id);

    void loadZhihuDailyContent(int id);

    void loadGuokrHandpickContent(int id);

    void getLink(ContentType type, int requestCode, int id);

  }
}
