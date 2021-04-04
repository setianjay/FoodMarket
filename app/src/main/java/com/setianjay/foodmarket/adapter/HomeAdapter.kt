package com.setianjay.foodmarket.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.setianjay.foodmarket.databinding.ItemHomeHorizontalBinding
import com.setianjay.foodmarket.model.dummy.HomeModel

class HomeAdapter(private val listView: List<HomeModel>, private val listener: OnAdapterListener): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private val TAG = "HomeAdapter"

    interface OnAdapterListener{
        fun onClick(v: View,data: HomeModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ItemHomeHorizontalBinding.inflate(
        LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = listView.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listView[position],listener)
    }

    inner class ViewHolder(val binding: ItemHomeHorizontalBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data:HomeModel, listener:OnAdapterListener){
            Log.d(TAG,binding.tvTitleFood.text.toString())
            Log.d(TAG,"${binding.rbFood.rating}")
            binding.tvTitleFood.text = data.titleFood
            binding.rbFood.rating = data.ratingFood!!

            Glide.with(binding.ivFood.context)
                .load(data.posterFood)
                .into(binding.ivFood)

            binding.root.setOnClickListener { listener.onClick(it,data) }
        }
    }
}
