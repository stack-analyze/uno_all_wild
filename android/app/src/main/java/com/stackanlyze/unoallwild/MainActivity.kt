package com.stackanlyze.unoallwild

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.stackanlyze.unoallwild.ui.App
import com.stackanlyze.unoallwild.ui.theme.UnoAllWildTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { false }
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT

        enableEdgeToEdge()

        setContent { UnoAllWildTheme { App() } }
    }
}
