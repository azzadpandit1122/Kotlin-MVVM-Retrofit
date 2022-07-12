package com.example.kotlinapp.api

import com.example.kotlinapp.Modals.quoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")
    suspend fun getQuote(@Query("page") page: Int): Response<quoteList>

}