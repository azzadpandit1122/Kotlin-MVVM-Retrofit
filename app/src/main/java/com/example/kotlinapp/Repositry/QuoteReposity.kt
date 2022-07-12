package com.example.kotlinapp.Repositry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinapp.Modals.quoteList
import com.example.kotlinapp.api.QuoteService

class QuoteReposity(private val quoteService: QuoteService) {
    private val quotesLiveData = MutableLiveData<quoteList>()


    val quote :LiveData<quoteList>
    get() = quotesLiveData

    suspend fun getQuotes(page:Int)
    {
        val result = quoteService.getQuote(page)
        if (result.body() != null){
            quotesLiveData.postValue(result.body())
        }
    }
}