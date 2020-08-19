package com.example.retrofitchapter7.pojo


import com.google.gson.annotations.SerializedName

data class DeletePersonResponse(
    @SerializedName("result")
    val result: String
)