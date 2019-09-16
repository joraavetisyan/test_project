package com.testproject.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product (

    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("price")
    val price: Double
) : Parcelable