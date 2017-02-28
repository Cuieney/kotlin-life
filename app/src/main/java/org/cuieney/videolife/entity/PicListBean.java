package org.cuieney.videolife.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.cuieney.videolife.entity.wangyiBean.PicBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuieney on 17/2/28.
 */

public class PicListBean implements Parcelable{
    /**
     * pic : [{"type":2,"mo_type":2,"code":"533636470","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148824769773e4901488b004914ed7dbb57b90a065.jpg","randpic_ios5":"","randpic_desc":"洛天依","randpic_ipad":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14882477105aeec4dca69184bbbf5cf48c3feb6ab0.jpg","randpic_qq":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488247718c04cd5c6ff7e3ab806601bcaa1fb5988.jpg","randpic_2":"bos_client_1488247700447ba87b7a87c3c8831c44c7cf584f72","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488247700447ba87b7a87c3c8831c44c7cf584f72.jpg","special_type":0,"ipad_desc":"洛天依","is_publish":"111111"},{"type":2,"mo_type":2,"code":"533650362","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488256741e6b64186ba30398796aa7e20c9c479d1.jpg","randpic_ios5":"","randpic_desc":"上瘾","randpic_ipad":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148825675910c246f2c6fab8c233eda6e85dccdbe6.jpg","randpic_qq":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148825676353801863a56b401415f52c7caa161ef7.jpg","randpic_2":"bos_client_14882567448d23a321fc1658e73124606685a8efb2","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14882567448d23a321fc1658e73124606685a8efb2.jpg","special_type":0,"ipad_desc":"上瘾","is_publish":"111111"},{"type":6,"mo_type":4,"code":"http://music.baidu.com/h5pc/spec_detail?id=171&columnid=85","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488192512d9bc553dbaec89e635c16d09434fba03.jpg","randpic_ios5":"","randpic_desc":"百度音乐独家策划","randpic_ipad":"","randpic_qq":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14881925282e735a186210bd381eb5ada1e6718049.jpg","randpic_2":"bos_client_1488192515b271bd7cdb0f15cd4c84dce020230219","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488192515b271bd7cdb0f15cd4c84dce020230219.jpg","special_type":0,"ipad_desc":"百度音乐独家策划","is_publish":"111111"},{"type":11,"mo_type":8,"code":"http://music.baidu.com/playmv/316312199","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148825684797d6ff9072ea5c1cb7328a843de27ee1.jpg","randpic_ios5":"","randpic_desc":"敢","randpic_ipad":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488256860106f93e52c8d9b44178d2be6971be5d7.jpg","randpic_qq":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488256867b38e050c0ebac6902e8e0084c0fbef25.jpg","randpic_2":"bos_client_1488256851dcd4825422a59e42c2103c7a7be6fff7","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488256851dcd4825422a59e42c2103c7a7be6fff7.jpg","special_type":0,"ipad_desc":"敢","is_publish":"111111"},{"type":6,"mo_type":4,"code":"http://music.baidu.com/cms/webview/bigwig/vote_zb/index.html?liveid=lss-hbsv2v1u6hxjnwan","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148757750884583297d922fbfd86ee2ae967a2797d.jpg","randpic_ios5":"","randpic_desc":"2017说唱歌曲创作大赛","randpic_ipad":"","randpic_qq":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148757753083228022b5038d4d427ca758a829e7f1.jpg","randpic_2":"bos_client_148757751402f8f5351322e295beee7fe5579ab828","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148757751402f8f5351322e295beee7fe5579ab828.jpg","special_type":0,"ipad_desc":"2017说唱歌曲创作大赛","is_publish":"111111"},{"type":2,"mo_type":2,"code":"533597675","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488165438723a24f4104de74241005dc706f8274e.jpg","randpic_ios5":"","randpic_desc":"林宥嘉","randpic_ipad":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488165461f39e972c3f6e753096f524aab3cad7b6.jpg","randpic_qq":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148816546766839061f603aef19e03e0fa0a67917b.jpg","randpic_2":"bos_client_14881654421b9f24976d06ee9440649d4b1c213863","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14881654421b9f24976d06ee9440649d4b1c213863.jpg","special_type":0,"ipad_desc":"林宥嘉","is_publish":"111111"},{"type":2,"mo_type":2,"code":"533571170","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488161970a4ad57be8c847d3a76377a7b96a6caf5.jpg","randpic_ios5":"","randpic_desc":"我管你","randpic_ipad":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488161984d0853e01998b90b1a785eef50eb666ea.jpg","randpic_qq":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1488161989722cdf058ce0809c41f384e402ab1425.jpg","randpic_2":"bos_client_14881619738ab06ed8689ddaf168be38a6d9b8c977","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14881619738ab06ed8689ddaf168be38a6d9b8c977.jpg","special_type":0,"ipad_desc":"我管你","is_publish":"111111"}]
     * error_code : 22000
     */

    private int error_code;
    private List<PicBean> pic;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<PicBean> getPic() {
        return pic;
    }

    public void setPic(List<PicBean> pic) {
        this.pic = pic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.error_code);
        dest.writeList(this.pic);
    }

    public PicListBean() {
    }

    protected PicListBean(Parcel in) {
        this.error_code = in.readInt();
        this.pic = new ArrayList<PicBean>();
        in.readList(this.pic, PicBean.class.getClassLoader());
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
