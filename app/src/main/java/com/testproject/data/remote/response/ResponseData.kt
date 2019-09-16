package com.testproject.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.testproject.data.model.Category

data class ResponseData(

    @Expose
    @SerializedName("status_code")
    val statusCode: Int,

    @Expose
    @SerializedName("message")
    val message: String,

    @Expose
    @SerializedName("data")
    val data: List<Category>
)