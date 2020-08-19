package com.example.retrofitchapter7.edit

import com.example.retrofitchapter7.network.ApiClient
import com.example.retrofitchapter7.pojo.GetPersonsResponse
import com.example.retrofitchapter7.pojo.PutPersonBody
import com.example.retrofitchapter7.pojo.PutPersonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EditPersonPresenter(val listener: Listener) {

    fun updatePerson(result: GetPersonsResponse.Result) {
        val objectPut = PutPersonBody(result.firstName,result.lastName)
        ApiClient.instance.updatePerson(objectPut, result.iD.toString()).enqueue(object : Callback<PutPersonResponse> {
            override fun onFailure(call: Call<PutPersonResponse>, t: Throwable) {
                t.message?.let {
                    listener.onUpdatePersonFailed(it)
                }
            }

            override fun onResponse(
                call: Call<PutPersonResponse>,
                response: Response<PutPersonResponse>
            ) {
                listener.onUpdatePersonSuccess("Sukses mengubah data person")
            }

        })
    }

    interface Listener {
        fun onUpdatePersonSuccess(message: String)
        fun onUpdatePersonFailed(errorMessage: String)
    }
}