package com.britishbroadcast.mvvmintro101.model.network

import com.britishbroadcast.mvvmintro101.model.data.GitResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {

    @GET("/users/{user_name}/repos")
    fun getUserRepositories(@Path("user_name")userName: String): Call<GitResponse>
}