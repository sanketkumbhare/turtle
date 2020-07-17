package com.turtle.nest.model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiRequest {
    @SerializedName("bname")
    @Expose
    var bnme: String? = null
}