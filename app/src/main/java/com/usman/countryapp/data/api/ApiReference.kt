package com.usman.countryapp.data.api

import com.usman.countryapp.data.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiReference {
    const val COUNTRY_END_POINT="db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json"

    private val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiReference: ApiDetails = retrofit.create(ApiDetails::class.java)
}