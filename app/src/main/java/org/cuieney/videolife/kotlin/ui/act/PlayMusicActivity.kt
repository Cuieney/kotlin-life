package org.cuieney.videolife.kotlin.ui.act

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.text.format.DateUtils
import android.view.View
import android.widget.SeekBar
import org.cuieney.videolife.R
import org.cuieney.videolife.kotlin.base.SimpleActivity
import kotlinx.android.synthetic.main.acitivty_play_music.*
import org.cuieney.videolife.entity.MusicListBean
import org.cuieney.videolife.entity.wyBean.TracksBean
import org.cuieney.videolife.kotlin.ui.adapter.CoverFlowAdapter
import tv.danmaku.ijk.media.player.IjkMediaPlayer
import java.io.IOException
import java.util.*

class PlayMusicActivity : SimpleActivity() {
    val DATA = "DATA"
    lateinit var tracksBean: MusicListBean
    lateinit var nowPlayList: List<TracksBean>
    lateinit var adapter: CoverFlowAdapter
    lateinit var player: IjkMediaPlayer

    var playerIndex = 0
    lateinit var mHandler: Handler
    lateinit var mRunnable: Runnable
    var isContainue = true
    var mode = 0

    override val layout: Int = R.layout.acitivty_play_music

    override fun initEventAndData() {
        val intent = intent
        val extras = intent.extras
        tracksBean = extras.getParcelable<MusicListBean>(DATA)
        initGallery()
        initListener()
        initMeida()
    }

    private fun initMeida() {
        player = IjkMediaPlayer()
        player.reset()
        player.setOnPreparedListener { iMediaPlayer ->
            iMediaPlayer.start()
            current_time.text = "00:00"
            total_time.text = DateUtils.formatElapsedTime(iMediaPlayer.duration / 1000)
        }
        player.setOnErrorListener { iMediaPlayer, i, i1 ->
            iMediaPlayer.pause()
            false
        }
        player.setOnCompletionListener { iMediaPlayer -> changeMusic() }
        player.setOnSeekCompleteListener { it.start() }
        playMusic()
    }

    private fun playMusic() {
        try {
            player.reset()
            player.dataSource = nowPlayList[playerIndex].filename
            player.prepareAsync()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    private fun changeMusic() {
        var index = playerIndex
        when (mode) {
            1 -> index += 1
            2 -> playMusic()
            0 -> {
                val random = Random()
                var anInt = random.nextInt(10)
                if (anInt == index) {
                    anInt = random.nextInt(10)
                }
                index = anInt
            }
        }
        viewpager.setCurrentItem(index, true)
    }

    private fun initListener() {
        back.setOnClickListener { v -> finish() }
        progress.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                player.pause()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                val time = player.duration * (seekBar.progress * 0.01)
                player.seekTo(time.toLong())
            }
        })
        play_pause.setOnClickListener({ v ->
            if (player.isPlaying) {
                play_pause.setImageResource(R.drawable.play_msc_icon)
                player.pause()
            } else {
                player.start()
                play_pause.setImageResource(R.drawable.pause_msc_icon)
            }
        })

        model.setOnClickListener { v ->
            when (mode) {
                0 -> {
                    mode = 1
                    model.setImageResource(R.drawable.circle_icon)
                }
                1 -> {
                    mode = 2
                    model.setImageResource(R.drawable.single_play_icon)
                }
                2 -> {
                    mode = 0
                    model.setImageResource(R.drawable.random_icon)
                }
            }
        }

        next.setOnClickListener { v -> changeMusic() }
        updateProgress()
    }

    private fun updateProgress() {
        mRunnable = object : Runnable {
            override fun run() {
                if (isContainue) {
                    mHandler.postDelayed(this, 1000)
                }
                runOnUiThread {
                    val progress1 = (player.currentPosition * 1f / player.duration * 1f * 100).toInt()
                    progress.progress = progress1
                    current_time.text = DateUtils.formatElapsedTime(player.currentPosition / 1000)
                }
            }
        }
        mHandler = Handler()
        if (isContainue) {
            mHandler.postDelayed(mRunnable, 1000)
        }
    }

    private fun initGallery() {
        val nowPlayList = tracksBean.tracks

        if (nowPlayList == null || nowPlayList.size == 0) {
            return
        }
        this.nowPlayList = nowPlayList


        adapter = CoverFlowAdapter(nowPlayList, this)
        viewpager.setAdapter(adapter)
        viewpager.setOffscreenPageLimit(3)
        viewpager.setPageTransformer(true, ScalePageTransformer())
        headline.text = (nowPlayList[0].songname)
        name.text = nowPlayList[0].songer
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                playerIndex = position
                headline.text = nowPlayList[position].songname
                name.text = nowPlayList[position].songer
                playMusic()
            }

            override fun onPageScrollStateChanged(state: Int) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {

                }
            }
        })
    }


    inner class ScalePageTransformer : ViewPager.PageTransformer {
        val MAX_SCALE = 1.0f
        val MIN_SCALE = 0.8f
        override fun transformPage(page: View, position: Float) {
            var position = position

            if (position < -1) {
                position = -1f
            } else if (position > 1) {
                position = 1f
            }

            val tempScale = if (position < 0) 1 + position else 1 - position

            val slope = (MAX_SCALE - MIN_SCALE) / 1
            //一个公式
            val scaleValue = MIN_SCALE + tempScale * slope

            //设置缩放比例
            page.scaleX = scaleValue
            page.scaleY = scaleValue
            //设置透明度
            page.alpha = scaleValue
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        isContainue = false
        if (player.isPlaying) {
            player.pause()
            player.stop()
            player.release()
        }
    }
}
