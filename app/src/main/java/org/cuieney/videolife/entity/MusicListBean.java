package org.cuieney.videolife.entity;


import android.os.Parcel;
import android.os.Parcelable;

import org.cuieney.videolife.entity.wyBean.TracksBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuieney on 17/2/28.
 */

public class MusicListBean implements Parcelable {


    private String mid;
    private String mcode;
    private String resourcecode;
    private String mnum;
    private String mname;
    private String mdesc;
    private String mphoto;
    private String status;
    private String field2;
    private String ophoto;
    private String create_date;
    private String update_date;
    private String del_flag;
    private String hits;
    private String thumbnail_url;
    private String nshow;
    private String publish_time;
    private String create_time;
    private String comment_count;
    private String play_count;
    private String total_count;
    private List<TracksBean> tracks;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public String getResourcecode() {
        return resourcecode;
    }

    public void setResourcecode(String resourcecode) {
        this.resourcecode = resourcecode;
    }

    public String getMnum() {
        return mnum;
    }

    public void setMnum(String mnum) {
        this.mnum = mnum;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMdesc() {
        return mdesc;
    }

    public void setMdesc(String mdesc) {
        this.mdesc = mdesc;
    }

    public String getMphoto() {
        return mphoto;
    }

    public void setMphoto(String mphoto) {
        this.mphoto = mphoto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getOphoto() {
        return ophoto;
    }

    public void setOphoto(String ophoto) {
        this.ophoto = ophoto;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }


    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }


    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getNshow() {
        return nshow;
    }

    public void setNshow(String nshow) {
        this.nshow = nshow;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getPlay_count() {
        return play_count;
    }

    public void setPlay_count(String play_count) {
        this.play_count = play_count;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public List<TracksBean> getTracks() {
        return tracks;
    }

    public void setTracks(List<TracksBean> tracks) {
        this.tracks = tracks;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mid);
        dest.writeString(this.mcode);
        dest.writeString(this.resourcecode);
        dest.writeString(this.mnum);
        dest.writeString(this.mname);
        dest.writeString(this.mdesc);
        dest.writeString(this.mphoto);
        dest.writeString(this.status);
        dest.writeString(this.field2);
        dest.writeString(this.ophoto);
        dest.writeString(this.create_date);
        dest.writeString(this.update_date);
        dest.writeString(this.del_flag);
        dest.writeString(this.hits);
        dest.writeString(this.thumbnail_url);
        dest.writeString(this.nshow);
        dest.writeString(this.publish_time);
        dest.writeString(this.create_time);
        dest.writeString(this.comment_count);
        dest.writeString(this.play_count);
        dest.writeString(this.total_count);
        dest.writeList(this.tracks);
    }

    public MusicListBean() {
    }

    protected MusicListBean(Parcel in) {
        this.mid = in.readString();
        this.mcode = in.readString();
        this.resourcecode = in.readString();
        this.mnum = in.readString();
        this.mname = in.readString();
        this.mdesc = in.readString();
        this.mphoto = in.readString();
        this.status = in.readString();
        this.field2 = in.readString();
        this.ophoto = in.readString();
        this.create_date = in.readString();
        this.update_date = in.readString();
        this.del_flag = in.readString();
        this.hits = in.readString();
        this.thumbnail_url = in.readString();
        this.nshow = in.readString();
        this.publish_time = in.readString();
        this.create_time = in.readString();
        this.comment_count = in.readString();
        this.play_count = in.readString();
        this.total_count = in.readString();
        this.tracks = new ArrayList<TracksBean>();
        in.readList(this.tracks, TracksBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<MusicListBean> CREATOR = new Parcelable.Creator<MusicListBean>() {
        @Override
        public MusicListBean createFromParcel(Parcel source) {
            return new MusicListBean(source);
        }

        @Override
        public MusicListBean[] newArray(int size) {
            return new MusicListBean[size];
        }
    };
}
