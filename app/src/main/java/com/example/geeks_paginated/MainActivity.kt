package com.example.geeks_paginated

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.geeks_paginated.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var images = mutableListOf<ImageModel>()
    private var adapter = ImageAdapter(images)
    var page = 1

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {

            pageBtn.setOnClickListener {
                page++
                requestImage()
            }

            searchBtn.setOnClickListener {
                requestImage()
            }
        }
    }

    private fun ActivityMainBinding.requestImage() {
        RetrofitService.api.getImages(keyWord = imageEd.text.toString(), page = page)
            .enqueue(object : Callback<PixelModel> {

                override fun onResponse(
                    call: Call<PixelModel>,
                    response: Response<PixelModel>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            imageResycler.adapter = adapter
                            images.addAll(it.hits)
                            adapter.notifyDataSetChanged()
                        }
                    }
                }

                override fun onFailure(call: Call<PixelModel>, t: Throwable) {
                    Log.e("Edu", "onFailure: ${t.message}")
                }
            })
    }
}