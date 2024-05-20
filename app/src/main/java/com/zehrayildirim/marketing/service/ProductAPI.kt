package com.zehrayildirim.marketing.service
import retrofit2.Call
import com.zehrayildirim.marketing.model.Product
import retrofit2.http.GET

interface ProductAPI {
    @GET("products")
    fun getData(): Call<List<Product>>
}