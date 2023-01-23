package com.example.githubrepository.Repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {
    companion object{
        val BASE_URL = "https://api.github.com/"
        val authInterceptor=AuthInterceptor("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")
        val okHttpClient=okhttp3.OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()

        var githubApi:GithubApi?=null

        fun getClient(): GithubApi {

            if (githubApi == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                githubApi = retrofit.create(GithubApi::class.java)
            }
            return githubApi!!
        }
    }
}