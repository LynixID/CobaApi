package com.example.potterapi.PotterAPI


/*
"fullName": "Harry James Potter",
    "nickname": "Harry",
    "hogwartsHouse": "Gryffindor",
    "interpretedBy": "Daniel Radcliffe",
    "children": [
      "James Sirius Potter",
      "Albus Severus Potter",
      "Lily Luna Potter"
    ],
    "image": "https://raw.githubusercontent.com/fedeperin/potterapi/main/public/images/characters/harry_potter.png",
    "birthdate": "Jul 31, 1980",
    "index": 0
*/

data class Character(
    val fullName: String,
    val nickname: String,
    val hogwartsHouse: String,
    val interpretedBy: String,
    val children: Array<String>,
    val image: String,
    val birthdate: String,
    val index: Int
    )
