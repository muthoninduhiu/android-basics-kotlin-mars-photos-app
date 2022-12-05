package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET


//add base URL
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

//add a Retrofit builder to build and create a Retrofit object
private val retrofit = Retrofit.Builder()
    //Retrofit object with the base URL and the converter factory.
    .addConverterFactory(ScalarsConverterFactory.create())
    //create retrofit object
    .build()

//Create an interface that explains how Retrofit talks to our web server.
interface MarsApiService {
    @GET("/photos")
    suspend fun getPhotos() : String
}

//add a lazily initialized retrofit object property
object MarsApi{
        val retrofitService : MarsApiService by lazy{
            retrofit.create(MarsApiService::class.java)
        }
}