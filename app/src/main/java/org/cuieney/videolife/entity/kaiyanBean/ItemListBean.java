package org.cuieney.videolife.entity.kaiyanBean;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cuieney on 17/2/26.
 */

public class ItemListBean implements Parcelable {
    private String type;
    private DataBean data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeParcelable(this.data, flags);
    }

    public ItemListBean() {
    }

    protected ItemListBean(Parcel in) {
        this.type = in.readString();
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<ItemListBean> CREATOR = new Parcelable.Creator<ItemListBean>() {
        @Override
        public ItemListBean createFromParcel(Parcel source) {
            return new ItemListBean(source);
        }

        @Override
        public ItemListBean[] newArray(int size) {
            return new ItemListBean[size];
        }
    };
}
