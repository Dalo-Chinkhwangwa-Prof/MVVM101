package com.britishbroadcast.mvvmintro101.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.britishbroadcast.mvvmintro101.R
import com.britishbroadcast.mvvmintro101.viewmodel.GitViewModel
import kotlinx.android.synthetic.main.count_fragment_layout.*

class RepositoryCountFragment: Fragment() {


    private val gitViewModel by activityViewModels<GitViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.count_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gitViewModel.countLiveData.observe(viewLifecycleOwner, Observer {
            textView.text = getString(R.string.repository_count_d, it)
        })
    }


}