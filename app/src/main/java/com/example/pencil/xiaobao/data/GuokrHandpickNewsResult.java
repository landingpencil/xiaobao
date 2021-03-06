package com.example.pencil.xiaobao.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import com.example.pencil.xiaobao.database.converter.GuokrResultTypeConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

@Entity(tableName = "guokr_handpick_news")
@TypeConverters(GuokrResultTypeConverter.class)
public class GuokrHandpickNewsResult {

  @ColumnInfo(name = "image")
  @Expose
  @SerializedName("image")
  private String image;

  @ColumnInfo(name = "is_replyable")
  @Expose
  @SerializedName("is_replyable")
  private boolean isReplyable;

  @ColumnInfo(name = "channels")
  @Expose
  @SerializedName("channels")
  private List<GuokrHandpickContentChannel> channels;

  @ColumnInfo(name = "channel_keys")
  @Expose
  @SerializedName("channel_keys")
  private List<String> channelKeys;

  @ColumnInfo(name = "preface")
  @Expose
  @SerializedName("preface")
  private String preface;

  @PrimaryKey
  @ColumnInfo(name = "id")
  @Expose
  @SerializedName("id")
  private int id;

  @Embedded
  @Expose
  @SerializedName("subject")
  private GuokrHandpickContentChannel subject;

  @ColumnInfo(name = "copyright")
  @Expose
  @SerializedName("copyright")
  private String copyright;

  @Embedded
  @Expose
  @SerializedName("author")
  private GuokrHandpickNewsAuthor author;

  @ColumnInfo(name = "image_description")
  @Expose
  @SerializedName("image_description")
  private String imageDescription;

  @ColumnInfo(name = "is_show_summary")
  @Expose
  @SerializedName("is_show_summary")
  private boolean isShowSummary;

  @ColumnInfo(name = "minisite_key")
  @Expose
  @SerializedName("minisite_key")
  private String minisiteKey;

  @Embedded
  @Expose
  @SerializedName("image_info")
  private GuokrHandpickContentImageInfo imageInfo;

  @ColumnInfo(name = "subject_key")
  @Expose
  @SerializedName("subject_key")
  private String subjectKey;

  @Embedded
  @Expose
  @SerializedName("minisite")
  private GuokrHandpickContentMinisite minisite;

  @ColumnInfo(name = "tags")
  @Expose
  @SerializedName("tags")
  private List<String> tags;

  @ColumnInfo(name = "date_published")
  @Expose
  @SerializedName("date_published")
  private String datePublished;

  @ColumnInfo(name = "avatar")
  @Expose
  @SerializedName("avatar")
  private List<GuokrHandpickNewsAuthor> authors;

  @ColumnInfo(name = "replies_count")
  @Expose
  @SerializedName("replies_count")
  private int repliesCount;

  @ColumnInfo(name = "is_author_external")
  @Expose
  @SerializedName("is_author_external")
  private boolean isAuthorExternal;

  @ColumnInfo(name = "recommends_count")
  @Expose
  @SerializedName("recommends_count")
  private int recommendsCount;

  @ColumnInfo(name = "title_hide")
  @Expose
  @SerializedName("title_hide")
  private String titleHide;

  @ColumnInfo(name = "date_modified")
  @Expose
  @SerializedName("date_modified")
  private String dateModified;

  @ColumnInfo(name = "url")
  @Expose
  @SerializedName("url")
  private String url;

  @ColumnInfo(name = "title")
  @Expose
  @SerializedName("title")
  private String title;

  @ColumnInfo(name = "small_image")
  @Expose
  @SerializedName("small_image")
  private String smallImage;

  @ColumnInfo(name = "summary")
  @Expose
  @SerializedName("summary")
  private String summary;

  @ColumnInfo(name = "ukey_author")
  @Expose
  @SerializedName("ukey_author")
  private String ukeyAuthor;

  @ColumnInfo(name = "date_created")
  @Expose
  @SerializedName("date_created")
  private String dateCreated;

  @ColumnInfo(name = "resource_url")
  @Expose
  @SerializedName("resource_url")
  private String resourceUrl;

  @ColumnInfo(name = "favorite")
  @Expose
  private boolean favorite;

  @ColumnInfo(name = "timestamp")
  @Expose
  private long timestamp;

  public GuokrHandpickNewsResult() {}

  public boolean isFavorite() {
    return favorite;
  }

  public void setFavorite(boolean favorite) {
    this.favorite = favorite;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public boolean isReplyable() {
    return isReplyable;
  }

  public void setReplyable(boolean replyable) {
    isReplyable = replyable;
  }

  public List<GuokrHandpickContentChannel> getChannels() {
    return channels;
  }

  public void setChannels(List<GuokrHandpickContentChannel> channels) {
    this.channels = channels;
  }

  public List<String> getChannelKeys() {
    return channelKeys;
  }

  public void setChannelKeys(List<String> channelKeys) {
    this.channelKeys = channelKeys;
  }

  public String getPreface() {
    return preface;
  }

  public void setPreface(String preface) {
    this.preface = preface;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public GuokrHandpickContentChannel getSubject() {
    return subject;
  }

  public void setSubject(GuokrHandpickContentChannel subject) {
    this.subject = subject;
  }

  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public GuokrHandpickNewsAuthor getAuthor() {
    return author;
  }

  public void setAuthor(GuokrHandpickNewsAuthor author) {
    this.author = author;
  }

  public String getImageDescription() {
    return imageDescription;
  }

  public void setImageDescription(String imageDescription) {
    this.imageDescription = imageDescription;
  }

  public boolean isShowSummary() {
    return isShowSummary;
  }

  public void setShowSummary(boolean showSummary) {
    isShowSummary = showSummary;
  }

  public String getMinisiteKey() {
    return minisiteKey;
  }

  public void setMinisiteKey(String minisiteKey) {
    this.minisiteKey = minisiteKey;
  }

  public GuokrHandpickContentImageInfo getImageInfo() {
    return imageInfo;
  }

  public void setImageInfo(GuokrHandpickContentImageInfo imageInfo) {
    this.imageInfo = imageInfo;
  }

  public String getSubjectKey() {
    return subjectKey;
  }

  public void setSubjectKey(String subjectKey) {
    this.subjectKey = subjectKey;
  }

  public GuokrHandpickContentMinisite getMinisite() {
    return minisite;
  }

  public void setMinisite(GuokrHandpickContentMinisite minisite) {
    this.minisite = minisite;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public String getDatePublished() {
    return datePublished;
  }

  public void setDatePublished(String datePublished) {
    this.datePublished = datePublished;
  }

  public List<GuokrHandpickNewsAuthor> getAuthors() {
    return authors;
  }

  public void setAuthors(List<GuokrHandpickNewsAuthor> authors) {
    this.authors = authors;
  }

  public int getRepliesCount() {
    return repliesCount;
  }

  public void setRepliesCount(int repliesCount) {
    this.repliesCount = repliesCount;
  }

  public boolean isAuthorExternal() {
    return isAuthorExternal;
  }

  public void setAuthorExternal(boolean authorExternal) {
    isAuthorExternal = authorExternal;
  }

  public int getRecommendsCount() {
    return recommendsCount;
  }

  public void setRecommendsCount(int recommendsCount) {
    this.recommendsCount = recommendsCount;
  }

  public String getTitleHide() {
    return titleHide;
  }

  public void setTitleHide(String titleHide) {
    this.titleHide = titleHide;
  }

  public String getDateModified() {
    return dateModified;
  }

  public void setDateModified(String dateModified) {
    this.dateModified = dateModified;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSmallImage() {
    return smallImage;
  }

  public void setSmallImage(String smallImage) {
    this.smallImage = smallImage;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getUkeyAuthor() {
    return ukeyAuthor;
  }

  public void setUkeyAuthor(String ukeyAuthor) {
    this.ukeyAuthor = ukeyAuthor;
  }

  public String getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(String dateCreated) {
    this.dateCreated = dateCreated;
  }

  public String getResourceUrl() {
    return resourceUrl;
  }

  public void setResourceUrl(String resourceUrl) {
    this.resourceUrl = resourceUrl;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

}
