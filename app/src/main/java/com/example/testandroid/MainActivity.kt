package com.example.testandroid

import android.Manifest
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.testandroid.databinding.ActivityMainBinding
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.FileDataSource
import java.io.File


class MainActivity : AppCompatActivity() {
    lateinit var exoPlayer:ExoPlayer
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestPermissions(
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            10)
        exoPlayer = ExoPlayer.Builder(this).build()
        try {
            // bandwisthmeter is used for
            // getting default bandwidth
            exoPlayer = ExoPlayer.Builder(this).build()
            exoPlayer?.playWhenReady = true
            binding.exoPlayerView.player = exoPlayer
            val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
            val mediaItem =
                MediaItem.fromUri(Uri.fromFile(File("/storage/emulated/0/Android/data/vn.netacom.lomo.staging/files/video_new.mp4")))
            val mediaSource =
                ProgressiveMediaSource.Factory( FileDataSource.Factory())
                    .createMediaSource(mediaItem)
            exoPlayer?.setMediaSource(mediaSource)
            exoPlayer?.playWhenReady = true
            exoPlayer?.prepare()


        } catch (e: Exception) {
            // on below line we
            // are handling exception
            e.printStackTrace()
        }


    }



}