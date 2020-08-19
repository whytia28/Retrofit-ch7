package com.example.retrofitchapter7.main

import com.example.retrofitchapter7.pojo.GetPersonsResponse
import com.example.retrofitchapter7.network.ApiClient
import com.example.retrofitchapter7.pojo.DeletePersonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val listener: Listener) {

    fun getPersonList() {
        listener.showProgressBar()
        ApiClient.instance.getAllPerson().enqueue(object : Callback<GetPersonsResponse> {
            override fun onFailure(call: Call<GetPersonsResponse>, t: Throwable) {
                t.message?.let {
                    listener.getPersonListFailure(it)
                }
                listener.hideProgressBar()
            }

            override fun onResponse(
                call: Call<GetPersonsResponse>,
                response: Response<GetPersonsResponse>
            ) {
                response.body()?.result?.let {
                    listener.getPersonListSuccess(it.toMutableList())
                }
                listener.hideProgressBar()
            }

        })
    }

    fun goToAddActivity() {
        listener.goToAddActivity()
    }

    fun goToUpdateActivity(result: GetPersonsResponse.Result) {
        listener.goToUpdateActivity(result)
    }

    fun deletePerson(result: GetPersonsResponse.Result) {
        listener.showProgressBar()
        ApiClient.instance.deletePerson(result.iD.toString()).enqueue(object : Callback<DeletePersonResponse> {
            override fun onFailure(call: Call<DeletePersonResponse>, t: Throwable) {
                t.message?.let {
                    listener.onPersonDeleteFailed(it)
                }
            }

            override fun onResponse(
                call: Call<DeletePersonResponse>,
                response: Response<DeletePersonResponse>
            ) {
                listener.onPersonDeleteSuccess(response.message())
                listener.hideProgressBar()
            }

        })
    }

    interface Listener {
        fun getPersonListSuccess(personList: MutableList<GetPersonsResponse.Result>)
        fun getPersonListFailure(errMessage: String)
        fun showProgressBar()
        fun hideProgressBar()
        fun goToAddActivity()
        fun goToUpdateActivity(result: GetPersonsResponse.Result)
        fun onPersonDeleteSuccess(message: String)
        fun onPersonDeleteFailed(errorMessage: String)
    }
}