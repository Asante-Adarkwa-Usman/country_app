package com.usman.countryapp.data.api

import com.usman.countryapp.data.model.CountryItemModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiDetails {
    //Get all countries
    @GET(ApiReference.COUNTRY_END_POINT)
    suspend fun getCountries(): Response<ArrayList<CountryItemModel>>
}