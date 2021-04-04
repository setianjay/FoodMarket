package com.setianjay.foodmarket.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.setianjay.foodmarket.adapter.HomeAdapter
import com.setianjay.foodmarket.adapter.HomeTabLayoutAdapter
import com.setianjay.foodmarket.databinding.FragmentHomeBinding
import com.setianjay.foodmarket.model.dummy.HomeModel
import com.setianjay.foodmarket.model.dummy.HomeNewTasteModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var homeTabLayoutAdapter: HomeTabLayoutAdapter
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
        initTabLayout()
    }

    private fun initData(){
        dataFoods.add(HomeModel(titleFood = "Fried Rice",ratingFood = 4.5F))
        dataFoods.add(HomeModel(titleFood = "Martabak Bangka",ratingFood = 4.8F))
        dataFoods.add(HomeModel(titleFood = "Seblak Bandung",ratingFood = 4.7F))
    }

    private fun initRecycleView(){
        homeAdapter = HomeAdapter(dataFoods, object: HomeAdapter.OnAdapterListener{
            override fun onClick(v: View, data: HomeModel) {
                Toast.makeText(requireContext(),"Clicked!", Toast.LENGTH_SHORT).show()
            }
        })

        binding.rvFood.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = homeAdapter
            setHasFixedSize(true)
        }
    }

    private fun initTabLayout(){
        homeTabLayoutAdapter = HomeTabLayoutAdapter(childFragmentManager,lifecycle)
        binding.viewPager.adapter = homeTabLayoutAdapter

        val tabLayoutTitles = listOf("New Taste","Popular","Recommended")

        TabLayoutMediator(binding.tabLayout,binding.viewPager){title, position ->
            title.text = tabLayoutTitles[position]
        }.attach()
    }
}