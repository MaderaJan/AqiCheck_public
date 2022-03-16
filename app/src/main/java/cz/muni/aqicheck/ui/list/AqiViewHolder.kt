package cz.muni.aqicheck.ui.list

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cz.muni.aqicheck.R
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.databinding.ItemAiqListBinding

class AqiViewHolder(private val binding: ItemAiqListBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(listItem: AqiPresentableListItem, onItemClick: (AqiPresentableListItem) -> Unit) {
        // TODO 2.2 (S) Přiřazení barvy položky z listu pomocí AqiScale
        binding.aqiColorIndicator.backgroundTintList = ContextCompat.getColorStateList(itemView.context, R.color.aqi_green)

        binding.aqiValueTextView.text = listItem.aqi
        binding.cityNameTextView.text = listItem.station
        binding.timeTextView.text = listItem.time

        binding.cardContainer.setOnClickListener {
            onItemClick(listItem)
        }

        // TODO 9.1 (S) napsat IF pro přiřazení srdce jestli je nebo není favorite
        // TODO 9.2 (S) napsat click listener na srdíčko
    }
}