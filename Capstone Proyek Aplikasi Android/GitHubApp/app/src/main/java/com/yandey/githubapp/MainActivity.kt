package com.yandey.githubapp

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreenWithAnim(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun installSplashScreenWithAnim(savedInstanceState: Bundle?) {
        installSplashScreen().also {
            if (savedInstanceState == null) {
                it.setOnExitAnimationListener { splashScreenView ->
                    // Create custom animation.
                    splashScreenView.iconView.animate().rotation(180F).duration = 500L
                    ObjectAnimator.ofFloat(
                        splashScreenView.iconView,
                        View.TRANSLATION_Y,
                        0f,
                        -splashScreenView.iconView.height.toFloat()
                    ).apply {
                        interpolator = AnticipateInterpolator()
                        duration = 500L
                        doOnEnd { splashScreenView.remove() }
                        start()
                    }
                }
            }
        }
    }
}