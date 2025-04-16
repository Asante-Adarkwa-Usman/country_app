package com.usman.countryapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.usman.countryapp.data.repository.CountryRepositoryImpl
import com.usman.countryapp.vm.CountryViewModel

class CountryViewModelFactory(
    private val repository: CountryRepositoryImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CountryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
