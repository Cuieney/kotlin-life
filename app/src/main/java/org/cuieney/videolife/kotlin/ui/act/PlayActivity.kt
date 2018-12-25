package org.cuieney.videolife.kotlin.ui.act

import android.annotation.TargetApi
import android.content.pm.ActivityInfo
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.transition.Transition
import android.util.Log
import android.view.View
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.shuyu.gsyvideoplayer.GSYVideoPlayer
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import kotlinx.android.synthetic.main.activity_play.*
import org.cuieney.videolife.R
import org.cuieney.videolife.entity.kaiyanBean.DataBean
import org.cuieney.videolife.ui.video.OnTransitionListener
import org.cuieney.videolife.ui.video.SampleVideo
import org.cuieney.videolife.ui.video.SwitchVideoModel
import java.net.HttpURLConnection
import java.net.URL
import java.util.ArrayList

class PlayActivity : AppCompatActivity() {


    lateinit var orientationUtils: OrientationUtils

    private var isTransition: Boolean = false

    lateinit var transition: Transition

    lateinit var dataBean: DataBean


    private var list: MutableList<SwitchVideoModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        ButterKnife.bind(this)
        isTransition = intent.getBooleanExtra(TRANSITION, false)
        dataBean = intent.extras.getParcelable<DataBean>(DATA)
        init()
    }

    private fun init() {
        list = ArrayList<SwitchVideoModel>()
        Thread {
            try {
                list!!.add(SwitchVideoModel("普通", getRedirectUrl(dataBean!!.playUrl)))
//                list!!.add(SwitchVideoModel("高清", getRedirectUrl(dataBean!!.playInfo[1].url)))
                video_player.setUp(list, true, "")
            } catch (e: Exception) {
                e.printStackTrace()
            }


        }.start()


        //增加封面
        val imageView = ImageView(this)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        //        imageView.setImageResource(R.mipmap.xxx1);
        video_player.setThumbImageView(imageView)

        //增加title
        video_player.titleTextView.visibility = View.VISIBLE
        video_player.titleTextView.text = dataBean!!.title

        //设置返回键
        video_player.backButton.visibility = View.VISIBLE

        //设置旋转
        orientationUtils = OrientationUtils(this, video_player)

        //设置全屏按键功能
        video_player.fullscreenButton.setOnClickListener { orientationUtils!!.resolveByClick() }

        //videoPlayer.setBottomProgressBarDrawable(getResources().getDrawable(R.drawable.video_new_progress));
        //videoPlayer.setDialogVolumeProgressBar(getResources().getDrawable(R.drawable.video_new_volume_progress_bg));
        //videoPlayer.setDialogProgressBar(getResources().getDrawable(R.drawable.video_new_progress));
        //videoPlayer.setBottomShowProgressBarDrawable(getResources().getDrawable(R.drawable.video_new_seekbar_progress),
        //getResources().getDrawable(R.drawable.video_new_seekbar_thumb));
        //videoPlayer.setDialogProgressColor(getResources().getColor(R.color.colorAccent), -11);

        //是否可以滑动调整
        video_player.setIsTouchWiget(true)

        //设置返回按键功能
        video_player.backButton.setOnClickListener { v -> onBackPressed() }

        //过渡动画
        initTransition()
    }


    override fun onPause() {
        super.onPause()
        video_player.onVideoPause()
    }

    override fun onResume() {
        super.onResume()
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    override fun onDestroy() {
        super.onDestroy()
        if (orientationUtils != null)
            orientationUtils!!.releaseListener()
    }

    override fun onBackPressed() {
        //先返回正常状态
        if (orientationUtils!!.screenType == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            video_player.fullscreenButton.performClick()
            return
        }
        //释放所有
        video_player.setStandardVideoAllCallBack(null)
        GSYVideoPlayer.releaseAllVideos()
        if (isTransition && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            super.onBackPressed()
        } else {
            finish()
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        }
    }


    private fun initTransition() {
        if (isTransition && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            postponeEnterTransition()
            ViewCompat.setTransitionName(video_player, IMG_TRANSITION)
            addTransitionListener()
            startPostponedEnterTransition()
        } else {
            video_player.startPlayLogic()
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun addTransitionListener(): Boolean {
        transition = window.sharedElementEnterTransition
        if (transition != null) {
            transition!!.addListener(object : OnTransitionListener() {
                override fun onTransitionEnd(transition: Transition) {
                    super.onTransitionEnd(transition)
                    video_player.startPlayLogic()
                    transition.removeListener(this)
                }
            })
            return true
        }
        return false
    }


    @Throws(Exception::class)
    private fun getRedirectUrl(path: String): String {
        val conn = URL(path)
                .openConnection() as HttpURLConnection
        conn.instanceFollowRedirects = false
        conn.connectTimeout = 5000
        val headerField = conn.getHeaderField("Location")
        Log.e("oye", headerField)
        return headerField
    }

    companion object {

        val IMG_TRANSITION = "IMG_TRANSITION"
        val TRANSITION = "TRANSITION"
        val DATA = "DATA"
    }
}