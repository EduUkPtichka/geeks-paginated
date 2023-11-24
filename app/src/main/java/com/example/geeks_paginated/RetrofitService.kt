package com.example.geeks_paginated

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitService {

    val retrifit = Retrofit.Builder()
        .baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val  api = retrifit.create(PixaApi::class.java)
}