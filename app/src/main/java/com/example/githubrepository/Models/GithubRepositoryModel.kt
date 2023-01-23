package com.example.githubrepository.Models

import java.io.Serializable

data class GithubRepositoryModel (val id: Int,
                                  val node_id: String,
                                  val name: String,
                                  val full_name: String,
                                  val private: Boolean,
                                  val html_url: String,
                                  val description: String?,
                                  val language: String,
                                  val created_at: String,
                                  val updated_at: String,
                                  val pushed_at: String,
                                  val clone_url: String,
                                  val visibility: String)

