package com.example.kotlinapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinapp.Modals.quoteList
import com.example.kotlinapp.Repositry.QuoteReposity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val reposity: QuoteReposity):ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            reposity.getQuotes(1)
        }
    }
    val quotes :LiveData<quoteList>
    get() = reposity.quote

}