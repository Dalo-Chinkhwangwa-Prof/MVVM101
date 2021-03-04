package com.britishbroadcast.mvvmintro101.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.britishbroadcast.mvvmintro101.model.data.GitResponse
import com.britishbroadcast.mvvmintro101.model.data.GitResponseItem
import com.britishbroadcast.mvvmintro101.model.network.GitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitViewModel: ViewModel() {

    val gitLiveData: MutableLiveData<List<GitResponseItem>> = MutableLiveData()
    val countLiveData: MutableLiveData<Int> = MutableLiveData()
    private val gitRetrofit = GitRetrofit()
    var count = 0

    fun getUserRepositories(userName: String){
        Log.d("TAG_X", "1 : Thread ${Thread.currentThread().name}")
        gitRetrofit.getUserRepositories(userName)
            .enqueue(object: Callback<GitResponse>{
                override fun onFailure(call: Call<GitResponse>, t: Throwable) {

                    Log.d("TAG_X", "Error ${t.localizedMessage}")
                }

                override fun onResponse(call: Call<GitResponse>, response: Response<GitResponse>) {
                    response.body()?.let{
                        Log.d("TAG_X", "2 : Thread ${Thread.currentThread().name}")
                        gitLiveData.value = (it)
                        countLiveData.value = it.size
                    } ?: Log.d("TAG_X", "response null ${call.request().url()}")

                }
            })

    }

}