package com.usman.countryapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usman.countryapp.data.model.CountryItemModel
import com.usman.countryapp.data.repository.CountryRepositoryImpl
import com.usman.countryapp.utils.UiStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryViewModel(
    private val countryRepositoryImpl: CountryRepositoryImpl
): ViewModel() {

    private val _countries = MutableLiveData<UiStatus<ArrayList<CountryItemModel>>>(UiStatus.Loading)
    val countries : LiveData<UiStatus<ArrayList<CountryItemModel>>> = _countries

    fun getAllCountries(){
        viewModelScope.launch(Dispatchers.IO) {
            countryRepositoryImpl.getAllCountries().collect{
                _countries.postValue(it)
            }
        }
    }



}