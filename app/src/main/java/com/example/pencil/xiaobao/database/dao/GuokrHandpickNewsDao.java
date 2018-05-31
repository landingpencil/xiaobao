package com.example.pencil.xiaobao.database.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.example.pencil.xiaobao.data.GuokrHandpickNewsResult;
import java.util.List;

@Dao
public interface GuokrHandpickNewsDao {

  @Query("SELECT * FROM guokr_handpick_news LIMIT :limit OFFSET :offset")
  List<GuokrHandpickNewsResult> queryAllByOffsetAndLimit(int offset, int limit);

  @Query("SELECT * FROM guokr_handpick_news WHERE id = :id")
  GuokrHandpickNewsResult queryItemById(int id);

  @Query("SELECT * FROM guokr_handpick_news WHERE favorite = 1")
  List<GuokrHandpickNewsResult> queryAllFavorites();

  @Query("SELECT * FROM guokr_handpick_news WHERE (timestamp < :timestamp) AND (favorite = 0)")
  List<GuokrHandpickNewsResult> queryAllTimeoutItems(long timestamp);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insertAll(List<GuokrHandpickNewsResult> items);

  @Update
  void update(GuokrHandpickNewsResult item);

  @Delete
  void delete(GuokrHandpickNewsResult item);

}
