package com.setianjay.foodmarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.setianjay.foodmarket.R
import com.setianjay.foodmarket.databinding.ItemNewTasteBinding
import com.setianjay.foodmarket.model.dummy.HomeNewTasteModel
import com.setianjay.foodmarket.utils.helpers

class HomeNewTasteAdapter(private val listView: List<HomeNewTasteModel>, private val listener: OnAdapterListener):
    RecyclerView.Adapter<HomeNewTasteAdapter.ViewHolder>(){

    interface OnAdapterListener{
        fun onClick(v: View, data: HomeNewTasteModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemNewTasteBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    override fun getItemCount(): Int = listView.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listView[position],listener)
    }

    inner class ViewHolder(val binding: ItemNewTasteBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: HomeNewTasteModel, listener: OnAdapterListener){
            binding.tvTitleFood.text = data.titleFood
            binding.tvPrice.text = helpers.rupiahFormatting(data.priceFood!!)
            binding.rbFood.rating = data.ratingFood!!
            binding.rate.text = data.ratingFood.toString()

            Glide.with(binding.ivFood.context)
                .load(R.drawable.iv_sample_product)
                .into(binding.ivFood)

            binding.root.setOnClickListener {
                listener.onClick(it,data)
            }
        }
    }
}