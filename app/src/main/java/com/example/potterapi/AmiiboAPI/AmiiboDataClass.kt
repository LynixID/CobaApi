package com.example.potterapi.AmiiboAPI

import android.telephony.euicc.EuiccInfo

data class AmiiboDataClass(
    val amiibo: List<AmiiboItem>
)

data class AmiiboItem(
    val amiiboSeries: String,
    val character: String,
    val gameSeries: String,
    val head: String,
    val image: String,
    val name: String,
    val release: Release,
    val tail: String,
    val type: String

    )

data class Release(
    val au: String,
    val eu: String,
    val jp: String,
    val na: String
)
