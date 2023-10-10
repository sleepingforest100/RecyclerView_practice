package kz.just_code.recyclerview

import android.content.ClipData.Item
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kz.just_code.recyclerview.databinding.ItemCountryBinding
import kz.just_code.recyclerview.databinding.ItemRegionBinding

class CountryListAdapter(
    private val items: List<CountryListDto>
): RecyclerView.Adapter<BaseCountryViewHolder<*, String>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseCountryViewHolder<*, String> {
        return if (viewType == CountryListType.REGION_VIEW.ordinal) {
            RegionViewHolder(
                ItemRegionBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
                )
        } else CountryViewHolder(
                ItemCountryBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseCountryViewHolder<*, String>, position: Int) {
        holder.bindView(items[position].name)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType.ordinal
    }

    class CountryViewHolder(override val binding: ItemCountryBinding) :
        BaseCountryViewHolder<ItemCountryBinding, String>(binding) {
        override fun bindView(item: String) {
            // Log.e("Item", ">>> Item: $item")
            binding.title.text = item
        }
    }

    class RegionViewHolder(override val binding: ItemRegionBinding) :
        BaseCountryViewHolder<ItemRegionBinding, String>(binding) {
        override fun bindView(item: String) {
            // Log.e("Item", ">>> Item: $item")
            binding.root.text = item
        }

    }

}

abstract class BaseCountryViewHolder<VB: ViewBinding, T>(protected open val binding: VB):
    RecyclerView.ViewHolder(binding.root){
   abstract fun bindView(item: T)
}


enum class CountryListType{
    REGION_VIEW, COUNTRY_VIEW
}

data class CountryListDto(
    val viewType: CountryListType,
    val name: String
)