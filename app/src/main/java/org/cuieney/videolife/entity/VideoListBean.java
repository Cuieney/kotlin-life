package org.cuieney.videolife.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.cuieney.videolife.entity.kaiyanBean.ItemListBean;

import java.util.List;

/**
 * Created by cuieney on 17/2/24.
 */

public class VideoListBean implements Parcelable {

    private int count;
    private int total;
    private String nextPageUrl;
    private long date;
    private long nextPublishTime;
    private List<ItemListBean> itemList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeInt(this.total);
        dest.writeString(this.nextPageUrl);
        dest.writeLong(this.date);
        dest.writeLong(this.nextPublishTime);
        dest.writeTypedList(this.itemList);
    }

    public VideoListBean() {
    }

    protected VideoListBean(Parcel in) {
        this.count = in.readInt();
        this.total = in.readInt();
        this.nextPageUrl = in.readString();
        this.date = in.readLong();
        this.nextPublishTime = in.readLong();
        this.itemList = in.createTypedArrayList(ItemListBean.CREATOR);
    }

    public static final Parcelable.Creator<VideoListBean> CREATOR = new Parcelable.Creator<VideoListBean>() {
        @Override
        public VideoListBean createFromParcel(Parcel source) {
            return new VideoListBean(source);
        }

        @Override
        public VideoListBean[] newArray(int size) {
            return new VideoListBean[size];
        }
    };
}
