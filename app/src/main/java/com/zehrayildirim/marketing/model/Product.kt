package com.zehrayildirim.marketing.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("image")
    val imageUrl: String
)


