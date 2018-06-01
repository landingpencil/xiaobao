package com.example.pencil.xiaobao.favorites;

import com.example.pencil.xiaobao.BasePresenter;
import com.example.pencil.xiaobao.BaseView;
import com.example.pencil.xiaobao.data.DoubanMomentNewsPosts;
import com.example.pencil.xiaobao.data.GuokrHandpickNewsResult;
import com.example.pencil.xiaobao.data.ZhihuDailyNewsQuestion;
import java.util.List;

public interface FavoritesContract {

  interface View extends BaseView<Presenter> {

    boolean isActive();

    void setLoadingIndicator(boolean active);

    void showFavorites(List<ZhihuDailyNewsQuestion> zhihuList,
        List<DoubanMomentNewsPosts> doubanList,
        List<GuokrHandpickNewsResult> guokrList);

  }

  interface Presenter extends BasePresenter {

    void loadFavorites();

  }
}