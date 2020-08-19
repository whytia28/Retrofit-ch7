package com.example.retrofitchapter7.pojo


import com.google.gson.annotations.SerializedName

data class PostPersonBody(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String
)