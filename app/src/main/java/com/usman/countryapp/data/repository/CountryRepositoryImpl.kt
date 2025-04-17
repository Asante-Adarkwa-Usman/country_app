package com.usman.countryapp.data.repository

import com.usman.countryapp.data.api.ApiDetails
import com.usman.countryapp.data.model.CountryItemModel
import com.usman.countryapp.utils.UiStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CountryRepositoryImpl(
    private val apiDetails: ApiDetails
): CountryRepository {
    override suspend fun getAllCountries(): Flow<UiStatus<ArrayList<CountryItemModel>>> = flow {
        emit(UiStatus.Loading)
        try {
            val result = apiDetails.getCountries()
            if (result.isSuccessful) {
                val countryList = result.body()
                countryList?.let {
                    val sortedList = it.sortedBy { country ->  country.name }
                    emit(UiStatus.Success(ArrayList(sortedList)))
                } ?: emit(UiStatus.Error("Country is null or empty"))
            } else {
                emit(UiStatus.Error("Failed to fetch country data"))
            }
        } catch (e: Exception) {
            emit(UiStatus.Error(e.toString()))
        }
    }
}