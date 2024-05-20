package com.zehrayildirim.marketing.service

import com.zehrayildirim.marketing.model.Product

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductAPIService {
    private val baseUrl = "https://fakestoreapi.com/"
    private val api: ProductAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ProductAPI::class.java)
    }
    fun getData(): Call<List<Product>> {
        return api.getData()
    }
}