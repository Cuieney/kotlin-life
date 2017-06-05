package org.cuieney.videolife.kotlin.common.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import org.cuieney.videolife.R
import org.cuieney.videolife.entity.MusicListBean
import org.cuieney.videolife.entity.kaiyanBean.DataBean
import org.cuieney.videolife.kotlin.ui.act.PlayActivity
import org.cuieney.videolife.kotlin.ui.act.PlayMusicActivity

/**
 * Created by cuieney on 2017/6/5.
 */
object JumpUtils {
    fun goToMusicPlayer(activity: Activity, view: View, dataBean: MusicListBean) {
        val intent = Intent(activity, PlayMusicActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable("DATA", dataBean)
        intent.putExtras(bundle)
        intent.putExtra("TRANSITION", true)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val pair = Pair(view, "IMG_TRANSITION")
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity, pair)
            ActivityCompat.startActivity(activity, intent, activityOptions.toBundle())
        } else {
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        }
    }

    fun goToVideoPlayer(activity: Activity, view: View, dataBean: DataBean) {
        val intent = Intent(activity, PlayActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable("DATA", dataBean)
        intent.putExtras(bundle)
        intent.putExtra("TRANSITION", true)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val pair = Pair(view, "IMG_TRANSITION")
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity, pair)
            ActivityCompat.startActivity(activity, intent, activityOptions.toBundle())
        } else {
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        }
    }
}