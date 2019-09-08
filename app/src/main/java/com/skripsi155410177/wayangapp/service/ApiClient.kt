package com.skripsi155410177.wayangapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient{
    companion object {
        fun create() : TokohService {
            val baseUrl = "https://wayangserver.000webhostapp.com/v1/"
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(TokohService::class.java)
        }
    }
}