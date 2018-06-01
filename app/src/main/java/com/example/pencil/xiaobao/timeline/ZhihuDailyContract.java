package com.example.pencil.xiaobao.timeline;

import android.support.annotation.NonNull;
import com.example.pencil.xiaobao.BasePresenter;
import com.example.pencil.xiaobao.BaseView;
import com.example.pencil.xiaobao.data.ZhihuDailyNewsQuestion;
import java.util.List;

public interface ZhihuDailyContract {

  interface View extends BaseView<Presenter> {

    boolean isActive();

    void setLoadingIndicator(boolean active);

    void showResult(@NonNull List<ZhihuDailyNewsQuestion> list);

  }

  interface Presenter extends BasePresenter {

    void loadNews(boolean forceUpdate, boolean clearCache, long date);

  }

}