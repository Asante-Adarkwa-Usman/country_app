package com.usman.countryapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usman.countryapp.data.model.CountryItemModel
import com.usman.countryapp.data.repository.CountryRepository
import com.usman.countryapp.utils.UiStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryViewModel(
    private val countryRepository: CountryRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    private val _countries = MutableLiveData<UiStatus<ArrayList<CountryItemModel>>>(UiStatus.Loading)
    val countries : LiveData<UiStatus<ArrayList<CountryItemModel>>> = _countries

    fun getAllCountries(){
        viewModelScope.launch(dispatcher) {
            countryRepository.getAllCountries().collect{
                _countries.postValue(it)
            }
        }
    }
}