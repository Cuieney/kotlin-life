package org.cuieney.videolife.entity.VeerBean;

/**
 * Created by cuieney on 2017/6/6.
 */

public class UserBean {



    private int uid;
    private String userid;
    private String username;
    private ProfileBean profile;
    private boolean is_creator;
    private int vip_days_left;
    private boolean is_vip;
    private int following_count;
    private int follower_count;
    private boolean have_i_followed;
    private ThirdPartyAccountsBean third_party_accounts;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public boolean isIs_creator() {
        return is_creator;
    }

    public void setIs_creator(boolean is_creator) {
        this.is_creator = is_creator;
    }

    public int getVip_days_left() {
        return vip_days_left;
    }

    public void setVip_days_left(int vip_days_left) {
        this.vip_days_left = vip_days_left;
    }

    public boolean isIs_vip() {
        return is_vip;
    }

    public void setIs_vip(boolean is_vip) {
        this.is_vip = is_vip;
    }

    public int getFollowing_count() {
        return following_count;
    }

    public void setFollowing_count(int following_count) {
        this.following_count = following_count;
    }

    public int getFollower_count() {
        return follower_count;
    }

    public void setFollower_count(int follower_count) {
        this.follower_count = follower_count;
    }

    public boolean isHave_i_followed() {
        return have_i_followed;
    }

    public void setHave_i_followed(boolean have_i_followed) {
        this.have_i_followed = have_i_followed;
    }

    public ThirdPartyAccountsBean getThird_party_accounts() {
        return third_party_accounts;
    }

    public void setThird_party_accounts(ThirdPartyAccountsBean third_party_accounts) {
        this.third_party_accounts = third_party_accounts;
    }


}
