package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


//add base URL
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

//add a Retrofit builder to build and create a Retrofit object
private val retrofit = Retrofit.Builder()
    //Retrofit object with the base URL and the converter factory.
    .addConverterFactory(ScalarsConverterFactory.create())
   
class MarsApiService {
}