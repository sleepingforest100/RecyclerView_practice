package kz.just_code.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryList = CountryListMaker.getCountryList(this)
        val adapter = CountryListAdapter(countryList)

        binding.listView.adapter = adapter
        binding.listView.layoutManager = LinearLayoutManager(this)
    }
}