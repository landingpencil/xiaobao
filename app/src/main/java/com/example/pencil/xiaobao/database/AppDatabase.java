package com.example.pencil.xiaobao.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.example.pencil.xiaobao.data.DoubanMomentContent;
import com.example.pencil.xiaobao.data.DoubanMomentNewsPosts;
import com.example.pencil.xiaobao.data.GuokrHandpickContentResult;
import com.example.pencil.xiaobao.data.GuokrHandpickNewsResult;
import com.example.pencil.xiaobao.data.ZhihuDailyContent;
import com.example.pencil.xiaobao.data.ZhihuDailyNewsQuestion;
import com.example.pencil.xiaobao.database.dao.DoubanMomentContentDao;
import com.example.pencil.xiaobao.database.dao.DoubanMomentNewsDao;
import com.example.pencil.xiaobao.database.dao.GuokrHandpickContentDao;
import com.example.pencil.xiaobao.database.dao.GuokrHandpickNewsDao;
import com.example.pencil.xiaobao.database.dao.ZhihuDailyContentDao;
import com.example.pencil.xiaobao.database.dao.ZhihuDailyNewsDao;

@Database(entities = {
    ZhihuDailyNewsQuestion.class,
    DoubanMomentNewsPosts.class,
    GuokrHandpickNewsResult.class,
    ZhihuDailyContent.class,
    DoubanMomentContent.class,
    GuokrHandpickContentResult.class},
    version = 1)
public abstract class AppDatabase extends RoomDatabase {

  static final String DATABASE_NAME = "paper-plane-db";

  public abstract ZhihuDailyNewsDao zhihuDailyNewsDao();

  public abstract DoubanMomentNewsDao doubanMomentNewsDao();

  public abstract GuokrHandpickNewsDao guokrHandpickNewsDao();

  public abstract ZhihuDailyContentDao zhihuDailyContentDao();

  public abstract DoubanMomentContentDao doubanMomentContentDao();

  public abstract GuokrHandpickContentDao guokrHandpickContentDao();

}