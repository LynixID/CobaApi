package com.example.potterapi.PotterAPI

data class Book(
    val number:Int,
    val title: String,
    val releaseDate: String,
    val description: String,
    val pages: Int,
    val cover: String,
    val index: Int
)
