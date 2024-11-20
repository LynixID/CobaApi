package com.example.potterapi.PotterAPI

/*
{
    "house": "Gryffindor",
    "emoji": "🦁",
    "founder": "Godric Gryffindor",
    "colors": [
      "red",
      "gold"
    ],
    "animal": "Lion",
    "index": 0
  },
 */
data class House(
    val house: String,
    val emoji: String,
    val founder: String,
    val color: Array<String>,
    val animal: String,
    val index: Int
    )
