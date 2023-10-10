package kz.just_code.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CountryListAdapter(
    private val items: List<String>
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class CountryViewHolder(): RecyclerView.ViewHolder(){

    }
}