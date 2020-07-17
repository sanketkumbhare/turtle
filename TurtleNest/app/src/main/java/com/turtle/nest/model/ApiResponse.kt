package com.turtle.nest.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class ApiResponse {
    @SerializedName("status")
    @Expose
    var status: Int? = null

    @SerializedName("msg")
    @Expose
    var msg: String? = null

    @SerializedName("data")
    @Expose
    var data: Data? = null

    @SerializedName("errCode")
    @Expose
    var errCode: Int? = null

}