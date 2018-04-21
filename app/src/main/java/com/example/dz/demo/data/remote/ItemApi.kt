package com.example.dz.demo.data.remote

import com.example.dz.demo.data.model.ItemResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ItemApi {
    @GET("all.json")
    fun getItems(): Single<ItemResponse>
}