package com.setianjay.foodmarket.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.setianjay.foodmarket.ui.home.newtaste.HomeNewTasteFragment
import com.setianjay.foodmarket.ui.home.popular.HomePopularFragment
import com.setianjay.foodmarket.ui.home.recomended.HomeRecomendedFragment

class HomeTabLayoutAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {

    private val fragments = listOf(
        HomeNewTasteFragment(),
        HomePopularFragment(),
        HomeRecomendedFragment())


    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}