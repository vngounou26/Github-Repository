package com.example.githubrepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepository.Models.GithubRepositoryModel

class RepositoryDetailFramgmrntViewModel : ViewModel() {
    private val _selectedRepository = MutableLiveData<GithubRepositoryModel>()
    val selectedRepository: LiveData<GithubRepositoryModel> get() = _selectedRepository

    fun selectRepository(repository: GithubRepositoryModel){
        _selectedRepository.value = repository
    }
}