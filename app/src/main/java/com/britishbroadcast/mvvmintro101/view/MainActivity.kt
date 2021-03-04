package com.britishbroadcast.mvvmintro101.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.britishbroadcast.mvvmintro101.R
import com.britishbroadcast.mvvmintro101.viewmodel.GitViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private val gitViewModel by viewModels<GitViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gitViewModel.gitLiveData.observe(this, Observer {

            //TODO: display in a recycler view...

            val sb = StringBuilder()

            it.forEach {
                sb.append("${it.name}\n")
            }

            main_textview.text = sb.toString()
        })

        gitViewModel.getUserRepositories("Dalo-Chinkhwangwa-Prof")


    }
}