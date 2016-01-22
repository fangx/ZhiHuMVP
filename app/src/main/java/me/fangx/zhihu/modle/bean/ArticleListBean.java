package me.fangx.zhihu.modle.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fangxiao on 16/1/5.
 */
public class ArticleListBean implements Parcelable {

    private String[] images;

    private int type;

    private int id;

    private int ga_prefix;

    private String title;

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(int ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(this.images);
        dest.writeInt(this.type);
        dest.writeInt(this.id);
        dest.writeInt(this.ga_prefix);
        dest.writeString(this.title);
    }

    public ArticleListBean() {
    }

    protected ArticleListBean(Parcel in) {
        this.images = in.createStringArray();
        this.type = in.readInt();
        this.id = in.readInt();
        this.ga_prefix = in.readInt();
        this.title = in.readString();
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
