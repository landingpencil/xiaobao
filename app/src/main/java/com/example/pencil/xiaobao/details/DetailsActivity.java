package com.example.pencil.xiaobao.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.pencil.xiaobao.R;
import com.example.pencil.xiaobao.data.ContentType;
import com.example.pencil.xiaobao.data.source.local.DoubanMomentContentLocalDataSource;
import com.example.pencil.xiaobao.data.source.local.DoubanMomentNewsLocalDataSource;
import com.example.pencil.xiaobao.data.source.local.GuokrHandpickContentLocalDataSource;
import com.example.pencil.xiaobao.data.source.local.GuokrHandpickNewsLocalDataSource;
import com.example.pencil.xiaobao.data.source.local.ZhihuDailyContentLocalDataSource;
import com.example.pencil.xiaobao.data.source.local.ZhihuDailyNewsLocalDataSource;
import com.example.pencil.xiaobao.data.source.remote.DoubanMomentContentRemoteDataSource;
import com.example.pencil.xiaobao.data.source.remote.DoubanMomentNewsRemoteDataSource;
import com.example.pencil.xiaobao.data.source.remote.GuokrHandpickContentRemoteDataSource;
import com.example.pencil.xiaobao.data.source.remote.GuokrHandpickNewsRemoteDataSource;
import com.example.pencil.xiaobao.data.source.remote.ZhihuDailyContentRemoteDataSource;
import com.example.pencil.xiaobao.data.source.remote.ZhihuDailyNewsRemoteDataSource;
import com.example.pencil.xiaobao.data.source.repository.DoubanMomentContentRepository;
import com.example.pencil.xiaobao.data.source.repository.DoubanMomentNewsRepository;
import com.example.pencil.xiaobao.data.source.repository.GuokrHandpickContentRepository;
import com.example.pencil.xiaobao.data.source.repository.GuokrHandpickNewsRepository;
import com.example.pencil.xiaobao.data.source.repository.ZhihuDailyContentRepository;
import com.example.pencil.xiaobao.data.source.repository.ZhihuDailyNewsRepository;

public class DetailsActivity extends AppCompatActivity {
  public static final String KEY_ARTICLE_TYPE = "KEY_ARTICLE_TYPE";
  public static final String KEY_ARTICLE_ID = "KEY_ARTICLE_ID";
  public static final String KEY_ARTICLE_TITLE = "KEY_ARTICLE_TITLE";
  public static final String KEY_ARTICLE_IS_FAVORITE = "KEY_ARTICLE_IS_FAVORITE";

  private DetailsFragment mDetailsFragment;

  private ContentType mType;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.frame);

    if (savedInstanceState != null) {
      mDetailsFragment = (DetailsFragment) getSupportFragmentManager().getFragment(savedInstanceState, DetailsFragment.class.getSimpleName());
    } else {
      mDetailsFragment = DetailsFragment.newInstance();
      getSupportFragmentManager().beginTransaction()
          .add(R.id.container, mDetailsFragment, DetailsFragment.class.getSimpleName())
          .commit();
    }

    mType = (ContentType) getIntent().getSerializableExtra(KEY_ARTICLE_TYPE);
    if (mType == ContentType.TYPE_ZHIHU_DAILY) {

      new DetailsPresenter(mDetailsFragment,
          ZhihuDailyNewsRepository.getInstance(ZhihuDailyNewsRemoteDataSource.getInstance(),
              ZhihuDailyNewsLocalDataSource.getInstance(DetailsActivity.this)),
          ZhihuDailyContentRepository.getInstance(ZhihuDailyContentRemoteDataSource.getInstance(),
              ZhihuDailyContentLocalDataSource.getInstance(DetailsActivity.this)));

    } else if (mType == ContentType.TYPE_DOUBAN_MOMENT) {
      new DetailsPresenter(mDetailsFragment,
          DoubanMomentNewsRepository.getInstance(DoubanMomentNewsRemoteDataSource.getInstance(),
              DoubanMomentNewsLocalDataSource.getInstance(DetailsActivity.this)),
          DoubanMomentContentRepository.getInstance(DoubanMomentContentRemoteDataSource.getInstance(),
              DoubanMomentContentLocalDataSource.getInstance(DetailsActivity.this)));
    } else if (mType == ContentType.TYPE_GUOKR_HANDPICK) {
      new DetailsPresenter(mDetailsFragment,
          GuokrHandpickNewsRepository.getInstance(GuokrHandpickNewsRemoteDataSource.getInstance(),
              GuokrHandpickNewsLocalDataSource.getInstance(DetailsActivity.this)),
          GuokrHandpickContentRepository.getInstance(GuokrHandpickContentRemoteDataSource.getInstance(), GuokrHandpickContentLocalDataSource
              .getInstance(DetailsActivity.this)));
    }

  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    ZhihuDailyContentRepository.destroyInstance();
    DoubanMomentContentRepository.destroyInstance();
    GuokrHandpickContentRepository.destroyInstance();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    if (mDetailsFragment.isAdded()) {
      getSupportFragmentManager().putFragment(outState, DetailsFragment.class.getSimpleName(), mDetailsFragment);
    }
  }
}
