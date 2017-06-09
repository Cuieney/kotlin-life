package org.cuieney.videolife.entity.VeerBean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cuieney on 2017/6/6.
 */

public class UrlsBean {

    private String high;
    private String best;
    @SerializedName("default")
    private String defaultX;

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getBest() {
        return best;
    }

    public void setBest(String best) {
        this.best = best;
    }

    public String getDefaultX() {
        return defaultX;
    }

    public void setDefaultX(String defaultX) {
        this.defaultX = defaultX;
    }
}
