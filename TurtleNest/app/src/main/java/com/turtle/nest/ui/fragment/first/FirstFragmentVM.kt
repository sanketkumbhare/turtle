package com.turtle.nest.ui.fragment.first

import androidx.lifecycle.MutableLiveData
import com.turtle.nest.model.ApiResponse
import com.turtle.nest.model.data.ApiRequest
import com.turtle.nest.repository.networkoperator.ApiService
import com.turtle.nest.repository.networkoperator.NetworkAdapter
import com.turtle.nest.repository.networkoperator.ResponseCodes
import com.turtle.nest.utils.base.BaseVM
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragmentVM:BaseVM() {
    var isLoading = MutableLiveData<Boolean>()
    var apiresponse = MutableLiveData<ApiResponse>()

    init {
        isLoading.value = false
    }


     fun buttonClicked(btnValue: String){
         val apiRequest = ApiRequest()
         apiRequest.bnme = btnValue
         try {
             NetworkAdapter.apiService?.getCompanyDetails(apiRequest)?.enqueue(object: Callback<ApiResponse>{
                 override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

                 }

                 override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                     if (response.code() == ResponseCodes.Success)
                    apiresponse.value = response.body()
                 }

             } )
         }catch (e:Exception){
          e.stackTrace
         }



    }

}

