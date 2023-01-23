package com.example.githubrepository.adapters

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepository.Models.GithubRepositoryModel
import com.example.githubrepository.R
import com.example.githubrepository.RepositoryDetailFramgmrnt
import com.example.githubrepository.RepositoryListFragment
import com.example.githubrepository.RepositoryListFragmentDirections

class GithubRepositoryAdapter() :RecyclerView.Adapter<GithubRepositoryAdapter.GithubRepositoryViewHolder>() {
    class GithubRepositoryViewHolder(val view:android.view.View) :RecyclerView.ViewHolder(view){
        val cardview=view.findViewById<CardView>(R.id.card_view)
        val name = view.findViewById<TextView>(R.id.repository_title)
        val description = view.findViewById<TextView>(R.id.repository_description)
        //val stars = view.findViewById<TextView>(R.id.stars)
        //val language = view.findViewById<TextView>(R.id.language)
    }
    var repos= mutableListOf<GithubRepositoryModel>()

    fun setRepositoryList(reposList:List<GithubRepositoryModel>){
        this.repos= reposList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepositoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return GithubRepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubRepositoryViewHolder, position: Int) {
        val repo = repos[position]
        //holder.cardview.setOnClickListener(itemClickListener)
        holder.cardview.tag = position
        holder.name.text = repo.name
        holder.description.text = repo.description

        //holder.stars.text = repo.stars.toString()
        //holder.language.text = repo.language
    }

    override fun getItemCount(): Int {
        return repos.size
    }
}
