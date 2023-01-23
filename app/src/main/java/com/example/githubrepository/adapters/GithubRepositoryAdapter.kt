package com.example.githubrepository.adapters

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepository.Models.GithubRepositoryModel
import com.example.githubrepository.R
import com.example.githubrepository.RepositoryDetailFramgmrnt
import com.example.githubrepository.RepositoryListFragment
//import com.example.githubrepository.RepositoryListFragmentDirections

//import com.example.githubrepository.RepositoryListFragmentDirections

class GithubRepositoryAdapter(itemClickListener: OnClickListener) :RecyclerView.Adapter<GithubRepositoryAdapter.GithubRepositoryViewHolder>() {
    class GithubRepositoryViewHolder(val view:android.view.View) :RecyclerView.ViewHolder(view){
        val cardview=view.findViewById<ConstraintLayout>(R.id.card_view)
        val name = view.findViewById<TextView>(R.id.repository_title)
        val description = view.findViewById<TextView>(R.id.repository_description)
        val reposStatut=view.findViewById<ImageView>(R.id.reposStatut)

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

        holder.cardview.tag = position
        holder.name.text = repo.name

        if (repo.visibility=="public"){
            holder.reposStatut.setImageDrawable(ContextCompat.getDrawable(holder.cardview.context,R.drawable.public_repos))
        }else{
            holder.reposStatut.setImageDrawable(ContextCompat.getDrawable(holder.cardview.context,R.drawable.private_repos))
        }

        holder.description.text = repo.description

        /*holder.cardview.setOnClickListener {
            val position = it.tag as Int
            val repo = repos[position]
            val bundel= Bundle()
            bundel.putSerializable("repo",repo)
            var action =RepositoryListFragmentDirections.actionRepositoryListFragmentToRepositoryDetailFramgmrnt()
            it.findNavController().navigate(action)
        }*/

        //holder.stars.text = repo.stars.toString()
        //holder.language.text = repo.language
    }

    override fun getItemCount(): Int {
        return repos.size
    }
}
