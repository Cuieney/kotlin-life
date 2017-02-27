package org.cuieney.videolife.entity.kaiyanBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cuieney on 17/2/26.
 */

public class Tags implements Parcelable {

    /**
     * id : 140
     * name : 搞笑
     * actionUrl : eyepetizer://tag/140/?title=%E6%90%9E%E7%AC%91
     * adTrack : null
     */

    private int id;
    private String name;
    private String actionUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.actionUrl);
    }

    public Tags() {
    }

    protected Tags(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.actionUrl = in.readString();
    }

    public static final Parcelable.Creator<Tags> CREATOR = new Parcelable.Creator<Tags>() {
        @Override
        public Tags createFromParcel(Parcel source) {
            return new Tags(source);
        }

        @Override
        public Tags[] newArray(int size) {
            return new Tags[size];
        }
    };
}
