package com.example.retrofitchapter7.addperson

import com.example.retrofitchapter7.pojo.PostPersonBody
import com.example.retrofitchapter7.pojo.PostPersonResponse
import com.example.retrofitchapter7.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddPersonPresenter(val listener: Listener) {

    fun addPerson(firstName: String, lastName: String) {

        val person =
            PostPersonBody(firstName, lastName)

        ApiClient.instance.addPerson(person).enqueue(object : Callback<PostPersonResponse> {
            override fun onFailure(call: Call<PostPersonResponse>, t: Throwable) {

                listener.onAddPersonFailure(t.toString())
            }

            override fun onResponse(
                call: Call<PostPersonResponse>,
                response: Response<PostPersonResponse>
            ) {
                listener.onAddPersonSuccess("Add success")
            }

        })
    }

    interface Listener {
        fun onAddPersonSuccess(successMessage: String)
        fun onAddPersonFailure(failureMessage: String)
    }
}