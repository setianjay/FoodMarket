package com.setianjay.foodmarket.ui.auth.signup

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import com.setianjay.foodmarket.R
import com.setianjay.foodmarket.databinding.FragmentSignUpAddressBinding
import com.setianjay.foodmarket.ui.auth.AuthActivity

class SignUpAddressFragment : Fragment() {
    private lateinit var binding: FragmentSignUpAddressBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpAddressBinding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AuthActivity).setToolbars("SignupAddress")
        initListener()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initListener(){
        binding.btnSignupNow.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_sign_up_success,null)
            (activity as AuthActivity).setToolbars("SignupSuccess")

        }
    }
}