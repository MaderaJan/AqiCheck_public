package cz.muni.aqicheck.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.databinding.ItemAqiListBinding

class AqiAdapter(
    private val onItemClick: (AqiPresentableListItem) -> Unit
) : RecyclerView.Adapter<AqiViewHolder>() {

    // TODO 4. Data obsažená v Adpateru
    private var listItems: MutableList<AqiPresentableListItem> = mutableListOf()

    // TODO 5. Binding Layoutu Viewholderu
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AqiViewHolder {
        val binding = ItemAqiListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AqiViewHolder(binding)
    }

    // TODO 6. Binding data do ViewHolderu
    override fun onBindViewHolder(holder: AqiViewHolder, position: Int) {
        holder.bind(listItems[position], onItemClick)
    }

    // TODO 7. Binding data do ViewHolderu
    fun submitList(newListItems: List<AqiPresentableListItem>) {
        listItems = newListItems.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listItems.size
}
