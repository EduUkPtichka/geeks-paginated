package com.example.geeks_paginated


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {

    @GET("api/")
    fun getImages(@Query("key") key: String = "40861000-5ed5736c1ddaa911534642629",
                  @Query("q") keyWord: String,
                  @Query("per_page") perPage: Int = 3,
                  @Query("page") page: Int = 1,
    ): Call<PixelModel>

}