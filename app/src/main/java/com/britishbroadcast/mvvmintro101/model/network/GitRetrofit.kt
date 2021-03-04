package com.britishbroadcast.mvvmintro101.model.network

import com.britishbroadcast.mvvmintro101.model.data.GitResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitRetrofit {

    private val gitService: GitService = createGitService(createGitRetrofit())

    private fun createGitService(gitRetrofit: Retrofit): GitService =
        gitRetrofit.create(GitService::class.java)

    private fun createGitRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getUserRepositories(userName: String): Call<GitResponse> =
        gitService.getUserRepositories(userName)
}