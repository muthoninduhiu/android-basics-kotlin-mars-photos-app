package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


//add base URL
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
//add moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
//add a Retrofit builder to build and create a Retrofit object
private val retrofit = Retrofit.Builder()
    //Retrofit object with the base URL and the converter factory.
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    //create retrofit object
    .build()

//Create an interface that explains how Retrofit talks to our web server.
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos() : List<MarsPhoto>
}

//add a lazily initialized retrofit object property
object MarsApi{
        val retrofitService : MarsApiService by lazy{
            retrofit.create(MarsApiService::class.java)
        }
}