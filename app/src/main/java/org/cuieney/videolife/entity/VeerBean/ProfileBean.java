package org.cuieney.videolife.entity.VeerBean;

/**
 * Created by cuieney on 2017/6/6.
 */

public class ProfileBean {


    private int uid;
    private String name;
    private Object info;
    private String avatar_url;
    private String avatar_url_watermark;
    private String avatar_url_small;
    private String background_url;
    private boolean like_viewable;
    private Object gender;
    private Object birthday;
    private Object location;
    private String homepage;
    private Object geolocation;
    private String display_geolocation;
    private Object category_sequence;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getAvatar_url_watermark() {
        return avatar_url_watermark;
    }

    public void setAvatar_url_watermark(String avatar_url_watermark) {
        this.avatar_url_watermark = avatar_url_watermark;
    }

    public String getAvatar_url_small() {
        return avatar_url_small;
    }

    public void setAvatar_url_small(String avatar_url_small) {
        this.avatar_url_small = avatar_url_small;
    }

    public String getBackground_url() {
        return background_url;
    }

    public void setBackground_url(String background_url) {
        this.background_url = background_url;
    }

    public boolean isLike_viewable() {
        return like_viewable;
    }

    public void setLike_viewable(boolean like_viewable) {
        this.like_viewable = like_viewable;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Object getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Object geolocation) {
        this.geolocation = geolocation;
    }

    public String getDisplay_geolocation() {
        return display_geolocation;
    }

    public void setDisplay_geolocation(String display_geolocation) {
        this.display_geolocation = display_geolocation;
    }

    public Object getCategory_sequence() {
        return category_sequence;
    }

    public void setCategory_sequence(Object category_sequence) {
        this.category_sequence = category_sequence;
    }
}
