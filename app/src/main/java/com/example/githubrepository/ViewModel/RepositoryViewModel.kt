package com.example.githubrepository.ViewModel

import androidx.lifecycle.*
import com.example.githubrepository.Models.GithubRepositoryModel
import com.example.githubrepository.Repositories.GithubReposRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback

class RepositoryViewModel constructor(private val repository: GithubReposRepository): ViewModel() {

    val repositoryLiveData= MutableLiveData<List<GithubRepositoryModel>>()
    val errorList= MutableLiveData<String>()

    fun getAllRepository(){
        val response=repository.getAllRepository()
        response.enqueue(object : Callback<List<GithubRepositoryModel>> {
            override fun onResponse(
                call: Call<List<GithubRepositoryModel>>,
                response: retrofit2.Response<List<GithubRepositoryModel>>
            ) {
                if (response.isSuccessful){
                    repositoryLiveData.value=response.body()
                }
            }

            override fun onFailure(call: Call<List<GithubRepositoryModel>>, t: Throwable) {
                errorList.postValue(t.message)
            }

        })
    }

}