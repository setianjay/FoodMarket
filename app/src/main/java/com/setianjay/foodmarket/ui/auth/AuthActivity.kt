package com.setianjay.foodmarket.ui.auth

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.setianjay.foodmarket.R

class AuthActivity : AppCompatActivity() {
    private var pageRequest: Int = 0

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initData()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initData() {
        pageRequest = intent.getIntExtra("page_request", 0)
        if (pageRequest == 2) {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.fragmentSignIn, true)
                .build()

            Navigation.findNavController(findViewById(R.id.authHostFragment))
                .navigate(R.id.action_sign_up, null, navOptions)

            setToolbars("Signup")
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun setToolbars(currentFrag: String){
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        when(currentFrag){
            "Signup"-> {
                toolbar.title = "Sign Up"
                toolbar.subtitle = "Register and eat"
                toolbar.navigationIcon = ResourcesCompat.getDrawable(resources,R.drawable.ic_arrow_back_000,null)
                toolbar.setNavigationOnClickListener { onBackPressed() }
            }
            "SignupAddress" -> {
                toolbar.title = "Address"
                toolbar.subtitle = "Make sure it's valid"
                toolbar.navigationIcon = ResourcesCompat.getDrawable(resources,R.drawable.ic_arrow_back_000,null)
                toolbar.setNavigationOnClickListener { onBackPressed() }
            }
            "SignupSuccess" -> {
                toolbar.visibility = View.GONE
            }
        }
    }
}