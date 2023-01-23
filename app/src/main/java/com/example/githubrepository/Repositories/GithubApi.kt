package com.example.githubrepository.Repositories

import com.example.githubrepository.Models.GithubRepositoryModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {
    //get repositories from github api
    @GET("repos")
    fun getAllRepositories(): Call<List<GithubRepositoryModel>>

}
