package cz.muni.aqicheck.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.databinding.ItemAiqListBinding

class AqiAdapter(
    private val onItemClick: (AqiPresentableListItem) -> Unit,
    private val onFavouriteClick: (AqiPresentableListItem) -> Unit
) : RecyclerView.Adapter<AqiViewHolder>() {

    private var listItems: MutableList<AqiPresentableListItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AqiViewHolder {
        val binding = ItemAiqListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AqiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AqiViewHolder, position: Int) {
        holder.bind(listItems[position], onItemClick, onFavouriteClick)
    }

    fun submitList(newListItems: List<AqiPresentableListItem>) {
        listItems = newListItems.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listItems.size
}
