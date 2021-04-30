package com.hemmati.farhangian.presentation.videoplayer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.util.Util
import com.hemmati.farhangian.R
import kotlinx.android.synthetic.main.fragment_video_player.*

class VideoPlayerFragment : Fragment(R.layout.fragment_video_player) {

    private var player: SimpleExoPlayer? = null
    private var fileUrl: String = ""
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition: Long = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getUrlArgument()
        initPlayer()
    }

    private fun getUrlArgument() {
        fileUrl = requireArguments().getString("fileUrl", "")
    }

    private fun initPlayer() {
        player = SimpleExoPlayer.Builder(requireContext()).build()
        videoPlayer.player = player
        val mediaItem = MediaItem.fromUri(fileUrl)
        player?.setMediaItem(mediaItem)
        player?.prepare()
        player?.play()
    }

    private fun releasePlayer() {
        if (player != null) {
            playWhenReady = player?.playWhenReady ?: false
            playbackPosition = player?.currentPosition ?: 0
            currentWindow = player?.currentWindowIndex ?: 0
            player?.release()
            player = null
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initPlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        if ((Util.SDK_INT < 24 || player == null)) {
            initPlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }

}