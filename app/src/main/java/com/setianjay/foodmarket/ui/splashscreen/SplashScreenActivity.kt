package com.setianjay.foodmarket.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.setianjay.foodmarket.MainActivity
import com.setianjay.foodmarket.R
import com.setianjay.foodmarket.ui.auth.AuthActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        move()
    }

    private fun move(){
        Handler().postDelayed({
            startActivity(Intent(applicationContext,AuthActivity::class.java))
        }, 3000)
    }
}