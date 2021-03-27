package com.setianjay.foodmarket.ui.auth.signin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.setianjay.foodmarket.R
import com.setianjay.foodmarket.databinding.FragmentSignInBinding
import com.setianjay.foodmarket.ui.auth.AuthActivity

class SignInFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.btnSignin.setOnClickListener(this)
        binding.btnSignup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSignin -> {
            }
            R.id.btnSignup -> {
                val intent = Intent(requireContext(),AuthActivity::class.java)
                intent.putExtra("page_request",2)
                startActivity(intent)
            }
        }
    }
}