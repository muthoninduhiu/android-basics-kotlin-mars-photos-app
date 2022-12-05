package com.example.android.marsphotos.network

import com.squareup.moshi.Json

data class MarsPhoto(
    val id: String,
    @Json(name="image_src")val image_src: String
)