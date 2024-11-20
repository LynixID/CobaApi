package com.example.potterapi.PotterAPI

import retrofit2.http.GET
import retrofit2.http.Path

interface PotterHeadService {
    @GET("{lang}/books")
    suspend fun getBooks(@Path ("lang")language: String = "en"): List<Book>

    @GET("{lang}/characters")
    suspend fun getChars(@Path ("lang")language: String = "en"): List<Character>

    @GET("{lang}/houses")
    suspend fun getHouses(@Path ("lang")language: String = "en"): List<House>

    @GET("{lang}/spells")
    suspend fun getSpells(@Path ("lang")language: String = "en"): List<Spell>
}