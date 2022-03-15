package cz.muni.aqicheck.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cz.muni.aqicheck.databinding.FragmentFavoritesBinding
import cz.muni.aqicheck.util.getNowFormattedDateString

// TODO 10 (S) -> implementace FavoritesFragmentu
// TODO 10 (S) -> Fragment bude načítat pouze prvky uložené v DB
// TODO 10 (S) -> Lze použít stejný Adaptér a ViewHolder jako v listu
// TODO 10 (S) -> HINT: Logika zůstává více méně celá stejná, akorát se mění zdroj dat
class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.timeButton.setOnClickListener {
            binding.timeTextView.text = giveMeTime(binding.timeTextView.text.toString())
        }
    }

    private fun giveMeTime(previousText: String): String =
        "$previousText ${System.currentTimeMillis().getNowFormattedDateString()},"
}