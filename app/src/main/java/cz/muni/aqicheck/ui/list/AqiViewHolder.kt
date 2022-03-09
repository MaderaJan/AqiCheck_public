package cz.muni.aqicheck.ui.list

import androidx.recyclerview.widget.RecyclerView
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.databinding.ItemAiqListBinding

class AqiViewHolder(private val binding: ItemAiqListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(listItem: AqiPresentableListItem, onItemClick: (AqiPresentableListItem) -> Unit) {
        binding.aqiColorIndicator
        binding.aqiValueTextView
        binding.cityNameTextView
        binding.timeTextView
        binding.favoriteImageView


        binding.cardContainer.setOnClickListener {
            // TODO 9. (S) invoke click
        }
    }
}