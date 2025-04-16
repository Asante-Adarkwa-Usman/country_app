package com.usman.countryapp.data.model


import com.google.gson.annotations.SerializedName

data class CountryItemModel(
    val capital: String = "",
    val code: String = "",
    val currency: CurrencyModel = CurrencyModel(),
    val demonym: String? = null,
    val flag: String = "",
    val language: LanguageModel = LanguageModel(),
    val name: String = "",
    val region: String = ""
)