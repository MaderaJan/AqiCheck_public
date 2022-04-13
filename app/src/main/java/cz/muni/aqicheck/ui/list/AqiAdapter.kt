package cz.muni.aqicheck.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.databinding.ItemAiqListBinding

class AqiAdapter(
    private val onItemClick: (AqiPresentableListItem) -> Unit,
) : RecyclerView.Adapter<AqiViewHolder>() {

    private var listItems: MutableList<AqiPresentableListItem> = mutableListOf()
    lateinit var onFavoriteClick: (AqiPresentableListItem, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AqiViewHolder {
        val binding = ItemAiqListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AqiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AqiViewHolder, position: Int) {
        holder.bind(listItems[position], onItemClick, onFavoriteClick)
    }

    fun submitList(newListItems: List<AqiPresentableListItem>) {
        listItems = newListItems.toMutableList()
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        listItems.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateFavorite(position: Int, isFavorite: Boolean) {
        listItems[position] = listItems[position].copy(isFavorite = isFavorite)
        notifyItemChanged(position)
    }

    override fun getItemCount(): Int = listItems.size
}
