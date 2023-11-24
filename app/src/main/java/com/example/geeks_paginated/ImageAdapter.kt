package com.example.geeks_paginated

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.geeks_paginated.databinding.ActivityMainBinding
import com.example.geeks_paginated.databinding.ItemImageBinding

class ImageAdapter(val list: List<ImageModel>) : Adapter<ImageAdapter.ImageViewHolder>() {


    inner class ImageViewHolder(private val binding: ItemImageBinding) : ViewHolder(binding.root) {
        fun onBind(model: ImageModel) {
            binding.imageView.load(model.largeImageURL)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageAdapter.ImageViewHolder {
        return ImageViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageAdapter.ImageViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}


