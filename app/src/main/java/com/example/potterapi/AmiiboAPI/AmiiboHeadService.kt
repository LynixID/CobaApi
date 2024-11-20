package com.example.potterapi.AmiiboAPI

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AmiiboHeadService {
    @GET("amiibo/")
    suspend fun getMario(@Query("name") name: String): AmiiboDataClass
}