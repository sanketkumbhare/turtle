package com.turtle.nest.repository.networkoperator

import com.turtle.nest.model.ApiResponse
import com.turtle.nest.model.data.ApiRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {

    @POST("mhc/test_handle_click")
    fun getCompanyDetails(@Body string: ApiRequest): Call<ApiResponse>

}