package com.example.pencil.xiaobao.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoubanMomentNewsThumbs {

  /**
   * medium : {"url":"https://img1.doubanio.com/view/presto/medium/public/t126447.jpg","width":460,"height":306}
   * description :
   * large : {"url":"https://img1.doubanio.com/view/presto/large/public/t126447.jpg","width":460,"height":306}
   * tag_name : img_1
   * small : {"url":"https://img1.doubanio.com/view/presto/small/public/t126447.jpg","width":320,"height":212}
   * id : 126447
   */

  @Embedded
  @Expose
  @SerializedName("medium")
  private DoubanMomentNewsMedium medium;

  @ColumnInfo(name = "thumb_description")
  @Expose
  @SerializedName("description")
  private String description;

  @Embedded
  @Expose
  @SerializedName("large")
  private DoubanMomentNewsLarge large;

  @Expose
  @SerializedName("tag_name")
  private String tagName;

  @Embedded
  @Expose
  @SerializedName("small")
  private DoubanMomentNewsSmall small;

  @ColumnInfo(name = "thumb_id")
  @Expose
  @SerializedName("id")
  private int id;


  public DoubanMomentNewsThumbs() {
  }

  public DoubanMomentNewsMedium getMedium() {
    return medium;
  }

  public void setMedium(DoubanMomentNewsMedium medium) {
    this.medium = medium;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DoubanMomentNewsLarge getLarge() {
    return large;
  }

  public void setLarge(DoubanMomentNewsLarge large) {
    this.large = large;
  }

  public String getTagName() {
    return tagName;
  }

  public void setTagName(String tagName) {
    this.tagName = tagName;
  }

  public DoubanMomentNewsSmall getSmall() {
    return small;
  }

  public void setSmall(DoubanMomentNewsSmall small) {
    this.small = small;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
