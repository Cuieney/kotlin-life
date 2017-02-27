package org.cuieney.videolife.entity.kaiyanBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cuieney on 17/2/26.
 */

public class WebUrlBean implements Parcelable {


    /**
     * raw : http://www.eyepetizer.net/detail.html?vid=14714
     * forWeibo : http://www.eyepetizer.net/detail.html?vid=14714
     */

    private String raw;
    private String forWeibo;

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getForWeibo() {
        return forWeibo;
    }

    public void setForWeibo(String forWeibo) {
        this.forWeibo = forWeibo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.raw);
        dest.writeString(this.forWeibo);
    }

    public WebUrlBean() {
    }

    protected WebUrlBean(Parcel in) {
        this.raw = in.readString();
        this.forWeibo = in.readString();
    }

    public static final Parcelable.Creator<WebUrlBean> CREATOR = new Parcelable.Creator<WebUrlBean>() {
        @Override
        public WebUrlBean createFromParcel(Parcel source) {
            return new WebUrlBean(source);
        }

        @Override
        public WebUrlBean[] newArray(int size) {
            return new WebUrlBean[size];
        }
    };
}
