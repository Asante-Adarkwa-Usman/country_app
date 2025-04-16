package com.usman.countryapp.data.repository

import com.usman.countryapp.data.model.CountryItemModel
import com.usman.countryapp.utils.UiStatus
import kotlinx.coroutines.flow.Flow


interface CountryRepository {
    suspend fun getAllCountries(): Flow<UiStatus<ArrayList<CountryItemModel>>>
}