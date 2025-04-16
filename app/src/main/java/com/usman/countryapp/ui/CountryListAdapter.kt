package com.usman.countryapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.usman.countryapp.data.model.CountryItemModel
import com.usman.countryapp.databinding.ItemCountryCardBinding

class CountryListAdapter(
    private var countries: ArrayList<CountryItemModel>
) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(val binding: ItemCountryCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        with(holder.binding) {
            tvNameRegion.text = "${country.name}, ${country.region}"
            tvCode.text = country.code
            tvCapital.text = country.capital
        }
    }

    override fun getItemCount(): Int = countries.size

    fun updateList(newList: ArrayList<CountryItemModel>) {
        countries.clear()
        countries.addAll(newList)
        notifyDataSetChanged()
    }
}
