package org.cuieney.videolife.kotlin.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.webkit.WebSettings
import org.cuieney.videolife.R
import org.cuieney.videolife.entity.EssayDetailBean
import org.cuieney.videolife.kotlin.base.BaseFragment
import org.cuieney.videolife.kotlin.presenter.contract.EssayHomeDetailContract
import kotlinx.android.synthetic.main.essay_home_detail_fragment.*
import org.cuieney.videolife.common.component.EventUtil
import org.cuieney.videolife.kotlin.presenter.EssayHomeDetailPresenter

/**
 * Created by cuieney on 2017/5/23.
 */
class EssayHomeDetailFragment(pTypeId:String,pSourceId:String): BaseFragment<EssayHomeDetailPresenter>(),EssayHomeDetailContract.View{

    var typeId = 2404
    var sourceId =11680
    init {
        var bundle = Bundle()
        bundle.putString("id",pTypeId)
        bundle.putString("sourceId",pSourceId)
        arguments = bundle
    }

    override fun showContent(dataBeanList: EssayDetailBean) {
        title.text = dataBeanList.data.hp_title
        var authorTxt = dataBeanList.data.hp_author
        author.text = "文 / $authorTxt"
        val html = dataBeanList.data.hp_content

        web_view.settings.setJavaScriptEnabled(true)
        web_view.settings.setBlockNetworkImage(false)

        web_view.loadDataWithBaseURL(
                null, html, "text/html", "utf-8", null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle = arguments
        typeId = Integer.parseInt(bundle["id"] as String)
        sourceId = Integer.parseInt(bundle["sourceId"] as String)
    }

    override fun error(throwable: Throwable) {
    }

    override fun initInject() {
        getFragmentComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.essay_home_detail_fragment;

    override fun initEventAndData() {
        toolbar.title = "一个阅读"
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"))
        initToolbarNav(toolbar)
        mPresenter.getEssayDetailData(sourceId, typeId,this)
    }

    protected fun initToolbarNav(toolbar: Toolbar) {
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener { v -> _mActivity.onBackPressed() }
        toolbar.inflateMenu(R.menu.video_menu)
    }

    override fun onBackPressedSupport(): Boolean {
        EventUtil.sendEvent(false.toString() + "")
        return super.onBackPressedSupport()

    }


}