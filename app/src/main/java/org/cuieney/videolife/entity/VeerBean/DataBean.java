package org.cuieney.videolife.entity.VeerBean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cuieney on 2017/6/6.
 */

public class DataBean {


    private int uid;
    private int video_id;
    private String title;
    private String info;
    private UrlsBean urls;
    private String hls;
    private String player;
    private ThumbnailBean thumbnail;
    private ThumbnailResizedBean thumbnail_resized;
    private boolean is_stereo;
    private boolean is_3d;
    private Object stereo_type;
    private int fov;
    private double duration;
    private int like_count;
    private boolean have_i_liked;
    private int comment_count;
    private int view_count;
    private int share_count;
    private String status;
    private String publish_status;
    private String privacy;
    private String processing_status;
    private double time_delta_created_at;
    private boolean allow_download;
    private Object start_at;
    private Object end_at;
    private String timezone;
    private boolean featured;
    private int horizontal_degree;
    private int vertical_degree;
    private CreatorBean creator;
    private UserBean user;
    private List<MediaBean> media;
    private List<CategoriesBean> categories;
    private List<TagsBean> tags;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public UrlsBean getUrls() {
        return urls;
    }

    public void setUrls(UrlsBean urls) {
        this.urls = urls;
    }

    public String getHls() {
        return hls;
    }

    public void setHls(String hls) {
        this.hls = hls;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public ThumbnailBean getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailBean thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ThumbnailResizedBean getThumbnail_resized() {
        return thumbnail_resized;
    }

    public void setThumbnail_resized(ThumbnailResizedBean thumbnail_resized) {
        this.thumbnail_resized = thumbnail_resized;
    }

    public boolean isIs_stereo() {
        return is_stereo;
    }

    public void setIs_stereo(boolean is_stereo) {
        this.is_stereo = is_stereo;
    }

    public boolean isIs_3d() {
        return is_3d;
    }

    public void setIs_3d(boolean is_3d) {
        this.is_3d = is_3d;
    }

    public Object getStereo_type() {
        return stereo_type;
    }

    public void setStereo_type(Object stereo_type) {
        this.stereo_type = stereo_type;
    }

    public int getFov() {
        return fov;
    }

    public void setFov(int fov) {
        this.fov = fov;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public boolean isHave_i_liked() {
        return have_i_liked;
    }

    public void setHave_i_liked(boolean have_i_liked) {
        this.have_i_liked = have_i_liked;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublish_status() {
        return publish_status;
    }

    public void setPublish_status(String publish_status) {
        this.publish_status = publish_status;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getProcessing_status() {
        return processing_status;
    }

    public void setProcessing_status(String processing_status) {
        this.processing_status = processing_status;
    }

    public double getTime_delta_created_at() {
        return time_delta_created_at;
    }

    public void setTime_delta_created_at(double time_delta_created_at) {
        this.time_delta_created_at = time_delta_created_at;
    }

    public boolean isAllow_download() {
        return allow_download;
    }

    public void setAllow_download(boolean allow_download) {
        this.allow_download = allow_download;
    }

    public Object getStart_at() {
        return start_at;
    }

    public void setStart_at(Object start_at) {
        this.start_at = start_at;
    }

    public Object getEnd_at() {
        return end_at;
    }

    public void setEnd_at(Object end_at) {
        this.end_at = end_at;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public int getHorizontal_degree() {
        return horizontal_degree;
    }

    public void setHorizontal_degree(int horizontal_degree) {
        this.horizontal_degree = horizontal_degree;
    }

    public int getVertical_degree() {
        return vertical_degree;
    }

    public void setVertical_degree(int vertical_degree) {
        this.vertical_degree = vertical_degree;
    }

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<MediaBean> getMedia() {
        return media;
    }

    public void setMedia(List<MediaBean> media) {
        this.media = media;
    }

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }


}
