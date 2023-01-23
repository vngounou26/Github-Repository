package com.example.githubrepository

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepository.Models.GithubRepositoryModel
import com.example.githubrepository.Repositories.Client
import com.example.githubrepository.Repositories.GithubReposRepository
import com.example.githubrepository.ViewModel.RepositoryViewModel
import com.example.githubrepository.ViewModel.RepositoryViewModelFactory
import com.example.githubrepository.adapters.GithubRepositoryAdapter

class RepositoryListFragment : Fragment(), View.OnClickListener {

    private val TAG="RepositoryListFragment"

    private lateinit var viewModel: RepositoryViewModel
    private lateinit var adapter: GithubRepositoryAdapter
    private val githubApi = Client.getClient()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view=inflater.inflate(R.layout.fragment_repository_list, container, false)
        var recyclerView=view.findViewById<RecyclerView>(R.id.repository_list_recycler_view)


        viewModel = ViewModelProvider(this,RepositoryViewModelFactory(GithubReposRepository(githubApi))).get(RepositoryViewModel::class.java)
        adapter = GithubRepositoryAdapter()
        recyclerView.adapter = adapter

        viewModel.repositoryLiveData.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreateView: $it")
            adapter.setRepositoryList(it)
        })
        viewModel.errorList.observe(viewLifecycleOwner, Observer {

        })
        viewModel.getAllRepository()


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(RepositoryViewModel::class.java)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}