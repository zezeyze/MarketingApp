package com.zehrayildirim.marketing.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zehrayildirim.marketing.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.zehrayildirim.marketing.service.ProductAPIService

class MainViewModel : ViewModel()
{
    private val productAPI = ProductAPIService()
    val productData = MutableLiveData<List<Product>>()
    val productLoad = MutableLiveData<Boolean>()
    val productError = MutableLiveData<Boolean>()
    fun getDataFromAPI()
    {
        productLoad.value = true
        productAPI.getData().enqueue(object : Callback<List<Product>>
        {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>)
            {
                if (response.isSuccessful && response.body() != null)
                {
                    productData.value = response.body()
                    productError.value = false
                } else
                {
                    productError.value = true
                }
                productLoad.value = false
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable)
            {
                productLoad.value = false
                productError.value = true
                Log.e("RetrofitError", t.message.toString())
            }
        })
    }
}
