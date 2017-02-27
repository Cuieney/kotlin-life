package org.cuieney.videolife.entity.kaiyanBean;

import android.os.Parcel;
import android.os.Parcelable;

import org.cuieney.videolife.entity.VideoListBean;

import java.util.List;

/**
 * Created by cuieney on 17/2/26.
 */

public class PlayInfoBean implements Parcelable {
    private int height;
    private int width;
    private String name;
    private String type;
    private String url;
    private List<UrlListBean> urlList;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<UrlListBean> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<UrlListBean> urlList) {
        this.urlList = urlList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.height);
        dest.writeInt(this.width);
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeString(this.url);
        dest.writeTypedList(this.urlList);
    }

    public PlayInfoBean() {
    }

    protected PlayInfoBean(Parcel in) {
        this.height = in.readInt();
        this.width = in.readInt();
        this.name = in.readString();
        this.type = in.readString();
        this.url = in.readString();
        this.urlList = in.createTypedArrayList(UrlListBean.CREATOR);
    }

    public static final Parcelable.Creator<PlayInfoBean> CREATOR = new Parcelable.Creator<PlayInfoBean>() {
        @Override
        public PlayInfoBean createFromParcel(Parcel source) {
            return new PlayInfoBean(source);
        }

        @Override
        public PlayInfoBean[] newArray(int size) {
            return new PlayInfoBean[size];
        }
    };
}
