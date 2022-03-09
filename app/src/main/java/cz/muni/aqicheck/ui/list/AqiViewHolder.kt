package cz.muni.aqicheck.ui.list

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cz.muni.aqicheck.R
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.databinding.ItemAiqListBinding

class AqiViewHolder(private val binding: ItemAiqListBinding)
    : RecyclerView.ViewHolder(binding.root) {

    // TODO 1.1 předání callback -> onItemClick: (AqiPresentableListItem) -> Unit
    fun bind(listItem: AqiPresentableListItem, onItemClick: (AqiPresentableListItem) -> Unit) {
<<<<<<< HEAD
        binding.aqiColorIndicator
        binding.aqiValueTextView
        binding.cityNameTextView
        binding.timeTextView
        binding.favoriteImageView

=======
        binding.aqiColorIndicator.backgroundTintList = ContextCompat.getColorStateList(itemView.context, R.color.aqi_green)
        binding.aqiValueTextView.text = listItem.aqi
        binding.cityNameTextView.text = listItem.station
        binding.timeTextView.text = listItem.time
>>>>>>> origin

        binding.cardContainer.setOnClickListener {
            // TODO 1.2 invoke click
        }
    }
}