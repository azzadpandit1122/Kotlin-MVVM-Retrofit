package com.example.kotlinapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinapp.Repositry.QuoteReposity

class MainViewModelFactory(private val reposity: QuoteReposity) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(reposity) as T
    }
}