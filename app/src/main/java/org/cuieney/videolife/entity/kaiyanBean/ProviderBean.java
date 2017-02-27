package org.cuieney.videolife.entity.kaiyanBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cuieney on 17/2/26.
 */

public class ProviderBean implements Parcelable {

    /**
     * name : YouTube
     * alias : youtube
     * icon : http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
     */

    private String name;
    private String alias;
    private String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.alias);
        dest.writeString(this.icon);
    }

    public ProviderBean() {
    }

    protected ProviderBean(Parcel in) {
        this.name = in.readString();
        this.alias = in.readString();
        this.icon = in.readString();
    }

    public static final Parcelable.Creator<ProviderBean> CREATOR = new Parcelable.Creator<ProviderBean>() {
        @Override
        public ProviderBean createFromParcel(Parcel source) {
            return new ProviderBean(source);
        }

        @Override
        public ProviderBean[] newArray(int size) {
            return new ProviderBean[size];
        }
    };
}
