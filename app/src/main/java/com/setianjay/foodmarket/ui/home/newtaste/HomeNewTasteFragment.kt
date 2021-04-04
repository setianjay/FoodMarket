package com.setianjay.foodmarket.ui.home.newtaste

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.setianjay.foodmarket.R
import com.setianjay.foodmarket.adapter.HomeNewTasteAdapter
import com.setianjay.foodmarket.databinding.FragmentHomeNewTasteBinding
import com.setianjay.foodmarket.model.dummy.HomeNewTasteModel

class HomeNewTasteFragment : Fragment() {
    private lateinit var binding: FragmentHomeNewTasteBinding
    private val dataFoods = mutableListOf<HomeNewTasteModel>()
    private lateinit var newTasteAdapter: HomeNewTasteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeNewTasteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initRecycleView()
    }

    private fun initData(){
        dataFoods.add(HomeNewTasteModel(titleFood = "Fried Rice",ratingFood = 4.5F,priceFood = 20000,posterFood = R.drawable.iv_sample_product))
        dataFoods.add(HomeNewTasteModel(titleFood = "Martabak Bangka",ratingFood = 4.8F,priceFood = 15000,posterFood = R.drawable.iv_sample_product))
        dataFoods.add(HomeNewTasteModel(titleFood = "Seblak Bandung",ratingFood = 4.7F,priceFood = 10000,posterFood = R.drawable.iv_sample_product))
    }

    private fun initRecycleView(){
        newTasteAdapter = HomeNewTasteAdapter(dataFoods, object: HomeNewTasteAdapter.OnAdapterListener{
            override fun onClick(v: View, data: HomeNewTasteModel) {
                Toast.makeText(requireContext(),"Clicked!", Toast.LENGTH_SHORT).show()
            }
        })

        binding.rvNewTasteFood.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL,false)
            adapter = newTasteAdapter
            setHasFixedSize(true)
        }
    }
}