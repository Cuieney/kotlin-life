package org.cuieney.videolife.entity.wangyiBean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by cuieney on 17/2/28.
 */

public class ContentBean implements Parcelable {

    /**
     * listid : 364536482
     * listenum : 62922
     * collectnum : 301
     * title : 【环球之音】值得单曲循环的优质男声
     * pic_300 : http://musicugc.cdn.qianqian.com/ugcdiy/pic/90b94499801345506a63d978422547c7.jpg
     * tag : 流行,华语,欧美
     * desc : 环球音乐旗下聚集了一大批人气优秀的男歌手，有如Justin Bieber、Sam Smith、The Weeknd、陈奕迅等流行偶像，也有Maroon 5、Fall Out Boy、OneRepublic等强势乐团，还有Eminem、Kanye West、Drake等嘻哈天王，他们既有爆棚的人气，更有出彩的作品。本张歌单整理搜集了环球唱片旗下优质的男歌手以及精彩作品，首首都是值得单曲循环的上乘佳品，让你听根本停不下来！
     * pic_w300 : http://musicugc.cdn.qianqian.com/ugcdiy/pic/90b94499801345506a63d978422547c7.jpg
     * width : 300
     * height : 300
     * songIds : ["256393709","277878399","285168207","120102174","257613380","127018689","130215415","258952664","255704757","266838605"]
     */

    private String listid;
    private String listenum;
    private String collectnum;
    private String title;
    private String pic_300;
    private String tag;
    private String desc;
    private String pic_w300;
    private String width;
    private String height;
    private List<String> songIds;

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public String getListenum() {
        return listenum;
    }

    public void setListenum(String listenum) {
        this.listenum = listenum;
    }

    public String getCollectnum() {
        return collectnum;
    }

    public void setCollectnum(String collectnum) {
        this.collectnum = collectnum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_300() {
        return pic_300;
    }

    public void setPic_300(String pic_300) {
        this.pic_300 = pic_300;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPic_w300() {
        return pic_w300;
    }

    public void setPic_w300(String pic_w300) {
        this.pic_w300 = pic_w300;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List<String> getSongIds() {
        return songIds;
    }

    public void setSongIds(List<String> songIds) {
        this.songIds = songIds;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.listid);
        dest.writeString(this.listenum);
        dest.writeString(this.collectnum);
        dest.writeString(this.title);
        dest.writeString(this.pic_300);
        dest.writeString(this.tag);
        dest.writeString(this.desc);
        dest.writeString(this.pic_w300);
        dest.writeString(this.width);
        dest.writeString(this.height);
        dest.writeStringList(this.songIds);
    }

    public ContentBean() {
    }

    protected ContentBean(Parcel in) {
        this.listid = in.readString();
        this.listenum = in.readString();
        this.collectnum = in.readString();
        this.title = in.readString();
        this.pic_300 = in.readString();
        this.tag = in.readString();
        this.desc = in.readString();
        this.pic_w300 = in.readString();
        this.width = in.readString();
        this.height = in.readString();
        this.songIds = in.createStringArrayList();
    }

    public static final Parcelable.Creator<ContentBean> CREATOR = new Parcelable.Creator<ContentBean>() {
        @Override
        public ContentBean createFromParcel(Parcel source) {
            return new ContentBean(source);
        }

        @Override
        public ContentBean[] newArray(int size) {
            return new ContentBean[size];
        }
    };
}
