package com.gemidroid.gaads.presentation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.gemidroid.gaads.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val  intent = Intent(this, LeaderActivity::class.java)
        Handler(mainLooper).postDelayed( {
            startActivity(intent)
            finish()
        }, 2000)
    }
}