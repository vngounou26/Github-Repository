package com.example.githubrepository.Repositories

import com.example.githubrepository.Models.GithubRepositoryModel
import kotlinx.coroutines.flow.Flow

class GithubReposRepository constructor(private val githubApi: GithubApi) {
        fun getAllRepository()= githubApi.getAllRepositories()
    }


