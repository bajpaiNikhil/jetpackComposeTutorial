package com.example.jetpackcomposetutorial

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService{
    @GET("menu.json")
    suspend fun fetchMenu() : List<Category>
}

object API {

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://firtman.github.io/coffeemasters/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val menuService : ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}