package com.example.pencil.xiaobao.database.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.example.pencil.xiaobao.data.ZhihuDailyContent;

@Dao
public interface ZhihuDailyContentDao {

  @Query("SELECT * FROM zhihu_daily_content WHERE id = :id")
  ZhihuDailyContent queryContentById(int id);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insert(ZhihuDailyContent content);

  @Update
  void update(ZhihuDailyContent content);

  @Delete
  void delete(ZhihuDailyContent content);


}
