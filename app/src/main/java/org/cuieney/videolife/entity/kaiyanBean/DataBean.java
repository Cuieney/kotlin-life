package org.cuieney.videolife.entity.kaiyanBean;

import android.os.Parcel;
import android.os.Parcelable;

import org.cuieney.videolife.entity.VideoListBean;

import java.util.List;

/**
 * Created by cuieney on 17/2/26.
 */

public class DataBean implements Parcelable {
    private String dataType;
    private int id;
    private String title;
    private String description;
    private ProviderBean provider;
    private String category;
    private CoverBean cover;
    private String playUrl;
    private int duration;
    private WebUrlBean webUrl;
    private long releaseTime;
    private ConsumptionBean consumption;
    private String type;
    private int idx;
    private long date;
    private boolean collected;
    private boolean played;
    private List<PlayInfoBean> playInfo;
    private List<Tags> tags;



    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProviderBean getProvider() {
        return provider;
    }

    public void setProvider(ProviderBean provider) {
        this.provider = provider;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CoverBean getCover() {
        return cover;
    }

    public void setCover(CoverBean cover) {
        this.cover = cover;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public WebUrlBean getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(WebUrlBean webUrl) {
        this.webUrl = webUrl;
    }

    public long getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(long releaseTime) {
        this.releaseTime = releaseTime;
    }

    public ConsumptionBean getConsumption() {
        return consumption;
    }

    public void setConsumption(ConsumptionBean consumption) {
        this.consumption = consumption;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public List<PlayInfoBean> getPlayInfo() {
        return playInfo;
    }

    public void setPlayInfo(List<PlayInfoBean> playInfo) {
        this.playInfo = playInfo;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.dataType);
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeParcelable(this.provider, flags);
        dest.writeString(this.category);
        dest.writeParcelable(this.cover, flags);
        dest.writeString(this.playUrl);
        dest.writeInt(this.duration);
        dest.writeParcelable(this.webUrl, flags);
        dest.writeLong(this.releaseTime);
        dest.writeParcelable(this.consumption, flags);
        dest.writeString(this.type);
        dest.writeInt(this.idx);
        dest.writeLong(this.date);
        dest.writeByte(this.collected ? (byte) 1 : (byte) 0);
        dest.writeByte(this.played ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.playInfo);
        dest.writeTypedList(this.tags);
    }

    public DataBean() {
    }

    protected DataBean(Parcel in) {
        this.dataType = in.readString();
        this.id = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        this.provider = in.readParcelable(ProviderBean.class.getClassLoader());
        this.category = in.readString();
        this.cover = in.readParcelable(CoverBean.class.getClassLoader());
        this.playUrl = in.readString();
        this.duration = in.readInt();
        this.webUrl = in.readParcelable(WebUrlBean.class.getClassLoader());
        this.releaseTime = in.readLong();
        this.consumption = in.readParcelable(ConsumptionBean.class.getClassLoader());
        this.type = in.readString();
        this.idx = in.readInt();
        this.date = in.readLong();
        this.collected = in.readByte() != 0;
        this.played = in.readByte() != 0;
        this.playInfo = in.createTypedArrayList(PlayInfoBean.CREATOR);
        this.tags = in.createTypedArrayList(Tags.CREATOR);
    }

    public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
        @Override
        public DataBean createFromParcel(Parcel source) {
            return new DataBean(source);
        }

        @Override
        public DataBean[] newArray(int size) {
            return new DataBean[size];
        }
    };
}
