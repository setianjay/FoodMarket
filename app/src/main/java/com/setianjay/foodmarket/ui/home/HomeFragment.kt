package com.setianjay.foodmarket.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.setianjay.foodmarket.R
import com.setianjay.foodmarket.adapter.HomeAdapter
import com.setianjay.foodmarket.databinding.FragmentHomeBinding
import com.setianjay.foodmarket.model.dummy.HomeModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val dataFoods: MutableList<HomeModel> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initRecycleView()
    }

    fun initData(){
        dataFoods.add(HomeModel(titleFood = "Fried Rice",ratingFood = 4.5F))
        dataFoods.add(HomeModel(titleFood = "Martabak Bangka",ratingFood = 4.8F))
        dataFoods.add(HomeModel(titleFood = "Seblak Bandung",ratingFood = 4.7F))
    }

    fun initRecycleView(){
        homeAdapter = HomeAdapter(dataFoods, object: HomeAdapter.OnAdapterListener{
            override fun onClick(v: View, data: HomeModel) {
                TODO("Not yet implemented")
            }
        })

        binding.rvFood.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = homeAdapter
            setHasFixedSize(true)
        }
    }
}