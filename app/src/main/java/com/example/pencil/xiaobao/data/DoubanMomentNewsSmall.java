package com.example.pencil.xiaobao.data;

import android.arch.persistence.room.ColumnInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoubanMomentNewsSmall {

  /**
   * url : https://img1.doubanio.com/view/presto/small/public/t126447.jpg
   * width : 320
   * height : 212
   */

  @ColumnInfo(name = "small_url")
  @Expose
  @SerializedName("url")
  private String url;

  @ColumnInfo(name = "small_width")
  @Expose
  @SerializedName("width")
  private int width;

  @ColumnInfo(name = "small_height")
  @Expose
  @SerializedName("height")
  private int height;

  public DoubanMomentNewsSmall() {

  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

}
