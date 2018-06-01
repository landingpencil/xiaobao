package com.example.pencil.xiaobao.timeline;

import android.support.annotation.NonNull;
import com.example.pencil.xiaobao.data.GuokrHandpickNewsResult;
import com.example.pencil.xiaobao.data.source.datasource.GuokrHandpickDataSource;
import com.example.pencil.xiaobao.data.source.repository.GuokrHandpickNewsRepository;
import java.util.List;

public class GuokrHandpickPresenter implements GuokrHandpickContract.Presenter {

  @NonNull
  private final GuokrHandpickContract.View mView;

  @NonNull
  private final GuokrHandpickNewsRepository mRepository;

  public GuokrHandpickPresenter(@NonNull GuokrHandpickContract.View  view,
      @NonNull GuokrHandpickNewsRepository repository) {
    this.mView = view;
    this.mRepository = repository;
    this.mView.setPresenter(this);
  }

  @Override
  public void load(boolean forceUpdate, boolean clearCache, int offset, int limit) {

    mRepository.getGuokrHandpickNews(forceUpdate, clearCache, offset, limit, new GuokrHandpickDataSource.LoadGuokrHandpickNewsCallback() {
      @Override
      public void onNewsLoad(@NonNull List<GuokrHandpickNewsResult> list) {
        if (mView.isActive()) {
          mView.showResult(list);
          mView.setLoadingIndicator(false);
        }
      }

      @Override
      public void onDataNotAvailable() {
        if (mView.isActive()) {
          mView.setLoadingIndicator(false);
        }
      }
    });
  }

  @Override
  public void start() {

  }
}
