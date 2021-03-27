package com.setianjay.foodmarket.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.setianjay.foodmarket.R

class AuthActivity : AppCompatActivity() {
    private var pageRequest: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initData()
    }

    private fun initData() {
        pageRequest = intent.getIntExtra("page_request", 0)
        if (pageRequest == 2) {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.fragmentSignIn, true)
                .build()

            Navigation.findNavController(findViewById(R.id.authHostFragment))
                .navigate(R.id.action_sign_up, null, navOptions)
        }
    }
}