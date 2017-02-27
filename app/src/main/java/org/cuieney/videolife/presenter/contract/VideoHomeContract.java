package org.cuieney.videolife.presenter.contract;

import org.cuieney.videolife.common.base.BasePresenter;
import org.cuieney.videolife.common.base.BaseView;
import org.cuieney.videolife.entity.VideoListBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cuieney on 17/2/24.
 */

public interface VideoHomeContract {

    interface View extends BaseView{
        void showContent(VideoListBean videoListBean);
        void error(Throwable throwable);
    }

    interface Presenter extends BasePresenter<View> {
        void getVideoData(String date);

    }
}
