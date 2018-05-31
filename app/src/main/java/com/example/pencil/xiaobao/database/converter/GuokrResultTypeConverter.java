package com.example.pencil.xiaobao.database.converter;

import android.arch.persistence.room.TypeConverter;
import com.example.pencil.xiaobao.data.GuokrHandpickContentChannel;
import com.example.pencil.xiaobao.data.GuokrHandpickNewsAuthor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GuokrResultTypeConverter {


  @TypeConverter
  public static String stringListToString(List<String> strings) {
    return new Gson().toJson(strings);
  }

  @TypeConverter
  public static List<String> stringToStringList(String string) {
    Type listType = new TypeToken<ArrayList<String>>(){}.getType();
    return new Gson().fromJson(string, listType);
  }

  @TypeConverter
  public static String resultListToString(List<GuokrHandpickContentChannel> channels) {
    return new Gson().toJson(channels);
  }

  @TypeConverter
  public static List<GuokrHandpickContentChannel> stringToResultList(String string) {
    Type listType = new TypeToken<ArrayList<GuokrHandpickContentChannel>>(){}.getType();
    return new Gson().fromJson(string, listType);
  }

  @TypeConverter
  public static String authorListToString(List<GuokrHandpickNewsAuthor> authors) {
    return new Gson().toJson(authors);
  }

  @TypeConverter
  public static List<GuokrHandpickNewsAuthor> stringToAuthorList(String string) {
    Type listType = new TypeToken<ArrayList<GuokrHandpickNewsAuthor>>(){}.getType();
    return new Gson().fromJson(string, listType);
  }

}
