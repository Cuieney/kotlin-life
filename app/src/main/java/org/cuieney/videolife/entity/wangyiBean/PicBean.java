package org.cuieney.videolife.entity.wangyiBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cuieney on 17/2/28.
 */

public class PicBean implements Parcelable {

    /**
     * type : 2
     * mo_type : 2
     * code : 533636470
     * randpic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_148824769773e4901488b004914ed7dbb57b90a065.jpg
     * randpic_ios5 :
     * randpic_desc : 洛天依
     * randpic_ipad : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14882477105aeec4dca69184bbbf5cf48c3feb6ab0.jpg
     * randpic_qq : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488247718c04cd5c6ff7e3ab806601bcaa1fb5988.jpg
     * randpic_2 : bos_client_1488247700447ba87b7a87c3c8831c44c7cf584f72
     * randpic_iphone6 : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488247700447ba87b7a87c3c8831c44c7cf584f72.jpg
     * special_type : 0
     * ipad_desc : 洛天依
     * is_publish : 111111
     */

    private int type;
    private int mo_type;
    private String code;
    private String randpic;
    private String randpic_ios5;
    private String randpic_desc;
    private String randpic_ipad;
    private String randpic_qq;
    private String randpic_2;
    private String randpic_iphone6;
    private int special_type;
    private String ipad_desc;
    private String is_publish;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMo_type() {
        return mo_type;
    }

    public void setMo_type(int mo_type) {
        this.mo_type = mo_type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRandpic() {
        return randpic;
    }

    public void setRandpic(String randpic) {
        this.randpic = randpic;
    }

    public String getRandpic_ios5() {
        return randpic_ios5;
    }

    public void setRandpic_ios5(String randpic_ios5) {
        this.randpic_ios5 = randpic_ios5;
    }

    public String getRandpic_desc() {
        return randpic_desc;
    }

    public void setRandpic_desc(String randpic_desc) {
        this.randpic_desc = randpic_desc;
    }

    public String getRandpic_ipad() {
        return randpic_ipad;
    }

    public void setRandpic_ipad(String randpic_ipad) {
        this.randpic_ipad = randpic_ipad;
    }

    public String getRandpic_qq() {
        return randpic_qq;
    }

    public void setRandpic_qq(String randpic_qq) {
        this.randpic_qq = randpic_qq;
    }

    public String getRandpic_2() {
        return randpic_2;
    }

    public void setRandpic_2(String randpic_2) {
        this.randpic_2 = randpic_2;
    }

    public String getRandpic_iphone6() {
        return randpic_iphone6;
    }

    public void setRandpic_iphone6(String randpic_iphone6) {
        this.randpic_iphone6 = randpic_iphone6;
    }

    public int getSpecial_type() {
        return special_type;
    }

    public void setSpecial_type(int special_type) {
        this.special_type = special_type;
    }

    public String getIpad_desc() {
        return ipad_desc;
    }

    public void setIpad_desc(String ipad_desc) {
        this.ipad_desc = ipad_desc;
    }

    public String getIs_publish() {
        return is_publish;
    }

    public void setIs_publish(String is_publish) {
        this.is_publish = is_publish;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeInt(this.mo_type);
        dest.writeString(this.code);
        dest.writeString(this.randpic);
        dest.writeString(this.randpic_ios5);
        dest.writeString(this.randpic_desc);
        dest.writeString(this.randpic_ipad);
        dest.writeString(this.randpic_qq);
        dest.writeString(this.randpic_2);
        dest.writeString(this.randpic_iphone6);
        dest.writeInt(this.special_type);
        dest.writeString(this.ipad_desc);
        dest.writeString(this.is_publish);
    }

    public PicBean() {
    }

    protected PicBean(Parcel in) {
        this.type = in.readInt();
        this.mo_type = in.readInt();
        this.code = in.readString();
        this.randpic = in.readString();
        this.randpic_ios5 = in.readString();
        this.randpic_desc = in.readString();
        this.randpic_ipad = in.readString();
        this.randpic_qq = in.readString();
        this.randpic_2 = in.readString();
        this.randpic_iphone6 = in.readString();
        this.special_type = in.readInt();
        this.ipad_desc = in.readString();
        this.is_publish = in.readString();
    }

    public static final Parcelable.Creator<PicBean> CREATOR = new Parcelable.Creator<PicBean>() {
        @Override
        public PicBean createFromParcel(Parcel source) {
            return new PicBean(source);
        }

        @Override
        public PicBean[] newArray(int size) {
            return new PicBean[size];
        }
    };
}
