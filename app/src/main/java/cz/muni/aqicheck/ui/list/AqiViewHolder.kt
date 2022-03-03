package cz.muni.aqicheck.ui.list

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cz.muni.aqicheck.R
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.databinding.ItemAqiListBinding

class AqiViewHolder(private val binding: ItemAqiListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(listItem: AqiPresentableListItem, onItemClick: (AqiPresentableListItem) -> Unit) {
        binding.aqiColorIndicator.backgroundTintList =
            ContextCompat.getColorStateList(
                binding.root.context, when {
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
            // TODO 9. (S) invoke click
            onItemClick(listItem)
        }
    }
}