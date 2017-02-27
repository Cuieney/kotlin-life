package org.cuieney.videolife.entity.kaiyanBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cuieney on 17/2/26.
 */

public class CoverBean implements Parcelable {

    /**
     * feed : http://img.kaiyanapp.com/248949ba05872fb9e18639fc3f4e8cc7.jpeg?imageMogr2/quality/60/format/jpg
     * detail : http://img.kaiyanapp.com/248949ba05872fb9e18639fc3f4e8cc7.jpeg?imageMogr2/quality/60/format/jpg
     * blurred : http://img.kaiyanapp.com/88ca155a37505fa15c8e3ca92a2882ae.jpeg?imageMogr2/quality/60/format/jpg
     * sharing : null
     */

    private String feed;
    private String detail;
    private String blurred;

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getBlurred() {
        return blurred;
    }

    public void setBlurred(String blurred) {
        this.blurred = blurred;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.feed);
        dest.writeString(this.detail);
        dest.writeString(this.blurred);
    }

    public CoverBean() {
    }

    protected CoverBean(Parcel in) {
        this.feed = in.readString();
        this.detail = in.readString();
        this.blurred = in.readString();
    }

    public static final Parcelable.Creator<CoverBean> CREATOR = new Parcelable.Creator<CoverBean>() {
        @Override
        public CoverBean createFromParcel(Parcel source) {
            return new CoverBean(source);
        }

        @Override
        public CoverBean[] newArray(int size) {
            return new CoverBean[size];
        }
    };
}
