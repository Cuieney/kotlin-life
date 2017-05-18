package org.cuieney.videolife.presenter.contract;

import org.cuieney.videolife.common.base.BasePresenter;
import org.cuieney.videolife.common.base.BaseView;
import org.cuieney.videolife.entity.EssayDetailBean;

import java.util.List;

/**
 * Created by cuieney on 2017/5/17.
 */

public interface EssayHomeDetailContract {
    interface View extends BaseView {
        void showContent(EssayDetailBean dataBeanList);
        void error(Throwable throwable);
    }

    interface Presenter extends BasePresenter<EssayHomeDetailContract.View> {
        void getEssayDetailData(int id,int sourceId);

    }
}
