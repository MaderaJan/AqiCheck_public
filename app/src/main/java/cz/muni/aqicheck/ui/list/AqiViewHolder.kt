package cz.muni.aqicheck.ui.list

import androidx.recyclerview.widget.RecyclerView
import cz.muni.aqicheck.R
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.databinding.ItemAiqListBinding

class AqiViewHolder(private val binding: ItemAiqListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(listItem: AqiPresentableListItem, onItemClick: (AqiPresentableListItem) -> Unit) {
  //      binding.aqiColorIndicator
  //      binding.aqiValueTextView
  //      binding.cityNameTextView
        binding.timeTextView.set listItem.time
        binding.favoriteImageView.setImageResource(
            if (listItem.isFavorite) {
                R.drawable.ic_heart
            } else {
                R.drawable.ic_heart_outline
            }
        )


        binding.cardContainer.setOnClickListener {
            // TODO 9. (S) invoke click
        }
    }
}