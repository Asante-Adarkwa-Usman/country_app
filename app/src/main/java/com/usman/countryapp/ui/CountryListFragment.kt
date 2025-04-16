package com.usman.countryapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.usman.countryapp.data.api.ApiDetails
import com.usman.countryapp.data.api.ApiReference
import com.usman.countryapp.data.repository.CountryRepositoryImpl
import com.usman.countryapp.databinding.FragmentCountryListBinding
import com.usman.countryapp.utils.UiStatus
import com.usman.countryapp.vm.CountryViewModel

class CountryListFragment : Fragment() {

    private var _binding: FragmentCountryListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CountryViewModel
    private lateinit var adapter: CountryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val apiDetails = ApiReference.apiReference
        val repository = CountryRepositoryImpl(apiDetails)
        val factory = CountryViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory)[CountryViewModel::class.java]


        adapter = CountryListAdapter(arrayListOf()) //initialize adapter(empty adapter)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.countries.observe(viewLifecycleOwner) { status ->
            when (status) {
                is UiStatus.Loading -> {
                    binding.progressBar.isVisible = true
                }

                is UiStatus.Success -> {
                    binding.progressBar.isVisible = false
                    adapter.updateList(status.data)
                }

                is UiStatus.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(requireContext(), status.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        viewModel.getAllCountries()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
