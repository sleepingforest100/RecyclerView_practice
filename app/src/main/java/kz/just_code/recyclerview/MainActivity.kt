package kz.just_code.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kz.just_code.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var position: Int = 0
        val countryList = CountryListMaker.getCountryList(this)
        val list: MutableList<CountryListDto> = mutableListOf()
        countryList.forEachIndexed{ index, item ->
            if (index % 8 == 0) list.add(CountryListDto(CountryListType.REGION_VIEW, "Region $index"))
           else  list.add(CountryListDto(CountryListType.COUNTRY_VIEW, item))
        }
        val adapter = CountryListAdapter(list)

        binding.listView.adapter = adapter
        binding.listView.layoutManager = LinearLayoutManager( this, RecyclerView.VERTICAL, false)
            //StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
    //GridLayoutManager(this, 2, RecyclerView.VERTICAL, true)

        binding.addButton.setOnClickListener{
                countryList[position] = position.toString()
                adapter.notifyItemChanged(position)
            position++
//            list.add(countryList[list.size])
//            adapter.notifyItemRangeChanged(list.size, list.size)
        }

    }
}