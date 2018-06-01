package com.example.pencil.xiaobao.timeline;

import android.support.annotation.NonNull;
import com.example.pencil.xiaobao.BasePresenter;
import com.example.pencil.xiaobao.BaseView;
import com.example.pencil.xiaobao.data.DoubanMomentNewsPosts;
import java.util.List;

public interface DoubanMomentContract {

  interface View extends BaseView<Presenter> {

    void setLoadingIndicator(boolean active);

    boolean isActive();

    void showResult(@NonNull List<DoubanMomentNewsPosts> list);

  }

  interface Presenter extends BasePresenter {

    void load(boolean forceUpdate, boolean clearCache, long date);

  }

}
