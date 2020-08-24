package com.example.retrofitchapter7.network

import com.example.retrofitchapter7.pojo.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("persons")
    fun getAllPerson(): Call<GetPersonsResponse>

    @POST("person")
    fun addPerson(@Body body: PostPersonBody): Call<PostPersonResponse>

    @PUT("person/{id}")
    fun updatePerson(@Body body: PutPersonBody, @Path("id") id: String): Call<PutPersonResponse>

    @DELETE("person/{id}")
    fun deletePerson(@Path("id") id: String): Call<DeletePersonResponse>

}