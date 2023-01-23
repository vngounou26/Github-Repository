package com.example.githubrepository.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubrepository.Repositories.GithubReposRepository

class RepositoryViewModelFactory constructor(private val githubReposRepository: GithubReposRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepositoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RepositoryViewModel(githubReposRepository) as T
        }
        else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
