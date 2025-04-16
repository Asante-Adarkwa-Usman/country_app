package com.usman.countryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.usman.countryapp.databinding.ActivityMainBinding
import com.usman.countryapp.ui.CountryListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load CountryListFragment when activity starts
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CountryListFragment())
                .commit()
        }
    }
}