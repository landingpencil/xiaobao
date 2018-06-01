package com.example.pencil.xiaobao;

import android.view.View;

public interface BaseView<T> {

  void setPresenter(T presenter);

  void initViews(View view);

}
