package me.fangx.zhihu.modle.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fangxiao on 16/1/5.
 */
public class ArticleListBean implements Parcelable {

    private String publishedTime;

    private Author author;

    private String title;

    private String titleImage;

    private String summary;

    private String content;

    private String url;

    private String href;

    private int commentsCount;

    private int likesCount;


    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.publishedTime);
        dest.writeParcelable(this.author, 0);
        dest.writeString(this.title);
        dest.writeString(this.titleImage);
        dest.writeString(this.summary);
        dest.writeString(this.content);
        dest.writeString(this.url);
        dest.writeString(this.href);
        dest.writeInt(this.commentsCount);
        dest.writeInt(this.likesCount);
    }

    public ArticleListBean() {
    }

    protected ArticleListBean(Parcel in) {
        this.publishedTime = in.readString();
        this.author = in.readParcelable(Author.class.getClassLoader());
        this.title = in.readString();
        this.titleImage = in.readString();
        this.summary = in.readString();
        this.content = in.readString();
        this.url = in.readString();
        this.href = in.readString();
        this.commentsCount = in.readInt();
        this.likesCount = in.readInt();
    }

    public static final Parcelable.Creator<ArticleListBean> CREATOR = new Parcelable.Creator<ArticleListBean>() {
        public ArticleListBean createFromParcel(Parcel source) {
            return new ArticleListBean(source);
        }

        public ArticleListBean[] newArray(int size) {
            return new ArticleListBean[size];
        }
    };
}
