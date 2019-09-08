package com.skripsi155410177.wayangapp.service

import com.skripsi155410177.wayangapp.model.Tokoh
import com.skripsi155410177.wayangapp.model.TokohResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TokohService {
    @GET("wayang/")
    fun getAllWayang(): Call<TokohResult>

    @GET("wayang/{id}")
    fun getWayangDetail(@Path("id") id: String): Call<Tokoh>
}
