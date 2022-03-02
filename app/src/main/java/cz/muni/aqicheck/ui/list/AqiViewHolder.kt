package cz.muni.aqicheck.ui.list

import androidx.recyclerview.widget.RecyclerView
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.databinding.ItemAiqListBinding

class AqiViewHolder(private val binding: ItemAiqListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(listItem: AqiPresentableListItem, onItemClick: (AqiPresentableListItem) -> Unit) {
        // TODO 8. (S) binding.aqiColorIndicator
        // TODO 8. (S) binding.aqiValueTextView
        // TODO 8. (S) binding.cityNameTextView
        // TODO 8. (S) binding.timeTextView
        // TODO 8. (S) binding.favoriteImageView

        binding.cardContainer.setOnClickListener {
            // TODO 9. (S) invoke click
        }
    }
}