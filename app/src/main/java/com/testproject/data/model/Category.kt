package com.testproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(

    @Expose
    @SerializedName("title")
    val title: String,

    @Expose
    @SerializedName("description")
    val description: String,

    @Expose
    @SerializedName("products")
    val products: List<Product>
)