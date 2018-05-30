package com.example.pencil.xiaobao.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;
import com.example.pencil.xiaobao.database.converter.DoubanTypeConverters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


@Entity(tableName = "douban_moment_news")
@TypeConverters(DoubanTypeConverters.class)
public class DoubanMomentNewsPosts {

  /**
   * display_style : 10002
   * is_editor_choice : false
   * published_time : 2017-08-14 22:00:00
   * original_url :
   * url : https://moment.douban.com/post/181332/?douban_rec=1
   * short_url : https://dou.bz/3lQDWp
   * is_liked : false
   * column : 洗洗睡
   * app_css : 7
   * abstract : 是谁偷偷偷走了月光……#光绘摄影#单次成像，非合成。地点：杭州太子湾，设备：大法a7RII
   * date : 2017-08-14
   * like_count : 109
   * comments_count : 98
   * thumbs : [{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/t126447.jpg","width":460,"height":306},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/t126447.jpg","width":460,"height":306},"tag_name":"img_1","small":{"url":"https://img1.doubanio.com/view/presto/small/public/t126447.jpg","width":320,"height":212},"id":126447}]
   * created_time : 2017-08-14 15:29:33
   * title : 洗洗睡｜群云青了脸，结伴回家去
   * share_pic_url : https://moment.douban.com/share_pic/post/181332.jpg
   * type : 1001
   * id : 181332
   * author : {"is_followed":false,"uid":"cindereeeella","url":"https://www.douban.com/people/cindereeeella/","avatar":"https://img3.doubanio.com/icon/u38627532-20.jpg","name":"红酥手贱","is_special_user":false,"n_posts":0,"alt":"身体不适，暂时两天一更╥﹏╥","large_avatar":"https://img3.doubanio.com/icon/up38627532-20.jpg","id":"38627532","is_auth_author":false}
   */

  @ColumnInfo(name = "display_style")
  @Expose
  @SerializedName("display_style")
  private int displayStyle;

  @ColumnInfo(name = "is_editor_choice")
  @Expose
  @SerializedName("is_editor_choice")
  private boolean isEditorChoice;

  @ColumnInfo(name = "published_time")
  @Expose
  @SerializedName("published_time")
  private String publishedTime;


  private String original_url;

  @ColumnInfo(name = "url")
  @Expose
  @SerializedName("url")
  private String url;

  @ColumnInfo(name = "short_url")
  @Expose
  @SerializedName("short_url")
  private String shortUrl;

  @ColumnInfo(name = "is_liked")
  @Expose
  @SerializedName("is_liked")
  private boolean isLiked;


  @Embedded
  @Expose
  @SerializedName("author")
  private DoubanMomentNewsAuthor author;


  @ColumnInfo(name = "column")
  @Expose
  @SerializedName("column")
  private String column;

  @ColumnInfo(name = "app_css")
  @Expose
  @SerializedName("app_css")
  private int appCss;


  @ColumnInfo(name = "abstract")
  @Expose
  @SerializedName("abstract")
  private String abs;

  @ColumnInfo(name = "date")
  @Expose
  @SerializedName("date")
  private String date;

  @ColumnInfo(name = "like_count")
  @Expose
  @SerializedName("like_count")
  private int likeCount;

  @ColumnInfo(name = "comments_count")
  @Expose
  @SerializedName("comments_count")
  private int commentsCount;


  @ColumnInfo(name = "thumbs")
  @Expose
  @SerializedName("thumbs")
  private List<DoubanMomentNewsThumbs> thumbs;


  @ColumnInfo(name = "created_time")
  @Expose
  @SerializedName("created_time")
  private String createdTime;

  @ColumnInfo(name = "title")
  @Expose
  @SerializedName("title")
  private String title;

  @ColumnInfo(name = "share_pic_url")
  @Expose
  @SerializedName("share_pic_url")
  private String sharePicUrl;

  @ColumnInfo(name = "type")
  @Expose
  @SerializedName("type")
  private String type;

  @ColumnInfo(name = "id")
  @Expose
  @SerializedName("id")
  private int id;

  @ColumnInfo(name = "favorite")
  @Expose
  private boolean favorite;

  @ColumnInfo(name = "timestamp")
  @Expose
  private long timestamp;

  public int getDisplayStyle() {
    return displayStyle;
  }

  public void setDisplayStyle(int displayStyle) {
    this.displayStyle = displayStyle;
  }

  public boolean isEditorChoice() {
    return isEditorChoice;
  }

  public void setEditorChoice(boolean editorChoice) {
    isEditorChoice = editorChoice;
  }

  public String getPublishedTime() {
    return publishedTime;
  }

  public void setPublishedTime(String publishedTime) {
    this.publishedTime = publishedTime;
  }

  public String getOriginal_url() {
    return original_url;
  }

  public void setOriginal_url(String original_url) {
    this.original_url = original_url;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getShortUrl() {
    return shortUrl;
  }

  public void setShortUrl(String shortUrl) {
    this.shortUrl = shortUrl;
  }

  public boolean isLiked() {
    return isLiked;
  }

  public void setLiked(boolean liked) {
    isLiked = liked;
  }

  public DoubanMomentNewsAuthor getAuthor() {
    return author;
  }

  public void setAuthor(DoubanMomentNewsAuthor author) {
    this.author = author;
  }

  public String getColumn() {
    return column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public int getAppCss() {
    return appCss;
  }

  public void setAppCss(int appCss) {
    this.appCss = appCss;
  }

  public String getAbs() {
    return abs;
  }

  public void setAbs(String abs) {
    this.abs = abs;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(int likeCount) {
    this.likeCount = likeCount;
  }

  public int getCommentsCount() {
    return commentsCount;
  }

  public void setCommentsCount(int commentsCount) {
    this.commentsCount = commentsCount;
  }

  public List<DoubanMomentNewsThumbs> getThumbs() {
    return thumbs;
  }

  public void setThumbs(List<DoubanMomentNewsThumbs> thumbs) {
    this.thumbs = thumbs;
  }

  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSharePicUrl() {
    return sharePicUrl;
  }

  public void setSharePicUrl(String sharePicUrl) {
    this.sharePicUrl = sharePicUrl;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isFavorite() {
    return favorite;
  }

  public void setFavorite(boolean favorite) {
    this.favorite = favorite;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}
