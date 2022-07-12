package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinapp.Repositry.QuoteReposity
import com.example.kotlinapp.api.QuoteService
import com.example.kotlinapp.api.RetrofitHelper
import com.example.kotlinapp.viewModel.MainViewModel
import com.example.kotlinapp.viewModel.MainViewModelFactory
class MainActivity : AppCompatActivity() {
    //https://quotable.io/quotes?page=1
    lateinit var mainViewModel :MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.tv) as TextView
        val quoteservice = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository  = QuoteReposity(quoteservice)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.quotes.observe(this,{
            Log.d("TAG", "CODE TEST: "+it.results.toString()+"\n")
            textView.setText(it.results.toString())
        })
    }
}

