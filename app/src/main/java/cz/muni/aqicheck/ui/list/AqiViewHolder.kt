package cz.muni.aqicheck.ui.list

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cz.muni.aqicheck.R
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.databinding.ItemAqiListBinding

class AqiViewHolder(private val binding: ItemAqiListBinding)
    : RecyclerView.ViewHolder(binding.root) {

    // TODO 1.1 předání callback -> onItemClick: (AqiPresentableListItem) -> Unit
    fun bind(listItem: AqiPresentableListItem, onItemClick: (AqiPresentableListItem) -> Unit) {
        binding.aqiColorIndicator.backgroundTintList = ContextCompat.getColorStateList(itemView.context, R.color.aqi_green)
        binding.aqiColorIndicator.backgroundTintList =
            ContextCompat.getColorStateList(
                itemView.context, when {
                    listItem.aqi.toInt() < 80 -> R.color.aqi_green
                    listItem.aqi.toInt() < 150 -> R.color.aqi_orange
                    else -> R.color.aqi_red
                }
            )
        binding.aqiValueTextView.text = listItem.aqi
        binding.cityNameTextView.text = listItem.station
        binding.timeTextView.text = listItem.time
        binding.favoriteImageView.setImageResource(
            if (listItem.isFavorite)
                R.drawable.ic_heart
            else
                R.drawable.ic_heart_outline
        )

        binding.cardContainer.setOnClickListener {
            // TODO 1.2 invoke click
            onItemClick(listItem)
        }
    }
}