package com.example.githubrepository

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

class RepositoryDetailFramgmrnt : Fragment() {

    companion object {
        fun newInstance() = RepositoryDetailFramgmrnt()
    }

    private lateinit var viewModel: RepositoryDetailFramgmrntViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_repository_detail_framgmrnt, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RepositoryDetailFramgmrntViewModel::class.java)

       /* val repo : RepositoryDetailFramgmrntViewModel
        repo.selectedRepository.observe(viewLifecycleOwner, Observer { repository ->
            // Update the UI, in this case, a TextView.
            textView.text = repository.name
        })*/
    }

}