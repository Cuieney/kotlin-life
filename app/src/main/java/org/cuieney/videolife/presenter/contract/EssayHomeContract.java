package org.cuieney.videolife.presenter.contract;

import org.cuieney.videolife.common.base.BasePresenter;
import org.cuieney.videolife.common.base.BaseView;
import org.cuieney.videolife.entity.MusicListBean;
import org.cuieney.videolife.entity.YiRenBean.DataBean;

import java.util.List;

/**
 * Created by cuieney on 2017/5/17.
 */
public interface EssayHomeContract {
    interface View extends BaseView {
        void showContent(List<DataBean> dataBeanList);
        void error(Throwable throwable);
    }

    interface Presenter extends BasePresenter<EssayHomeContract.View> {
        void getEssayData(int id);

    }
}
