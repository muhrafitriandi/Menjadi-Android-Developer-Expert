package com.yandey.githubapp

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.yandey.githubapp.databinding.ActivityMainBinding
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.preference.PreferenceManager
import com.yandey.githubapp.utils.DarkMode
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreenWithAnim(savedInstanceState)
        supportActionBar?.hide()

        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        preferences.getString(
            getString(R.string.pref_key_dark),
            getString(R.string.pref_dark_auto)
        )?.apply {
            val mode = DarkMode.valueOf(this.uppercase(Locale.US))
            when (mode.value.toString()) {
                getString(R.string.dark_mode_auto) -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                getString(R.string.dark_mode_on) -> AppCompatDelegate.MODE_NIGHT_YES
                getString(R.string.dark_mode_off) -> AppCompatDelegate.MODE_NIGHT_NO
            }
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.navHostFragment)
        setupActionBarWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)
        binding.bottomBar.setupWithNavController(menu!!, navController)
        return false
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
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