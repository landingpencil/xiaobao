package com.example.pencil.xiaobao.timeline;

import android.support.annotation.NonNull;
import com.example.pencil.xiaobao.BasePresenter;
import com.example.pencil.xiaobao.BaseView;
import com.example.pencil.xiaobao.data.GuokrHandpickNewsResult;
import java.util.List;

public interface GuokrHandpickContract {

  interface View extends BaseView<Presenter> {

    boolean isActive();

    void setLoadingIndicator(boolean active);

    void showResult(@NonNull List<GuokrHandpickNewsResult> list);

  }

  interface Presenter extends BasePresenter {

    void load(boolean forceUpdate, boolean clearCache, int offset, int limit);

  }

}
