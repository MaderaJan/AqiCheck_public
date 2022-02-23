package cz.muni.aqicheck.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cz.muni.aqicheck.databinding.FragmentFavoritesBinding
import java.time.LocalTime

class FavoritesFragment : Fragment() {

    // TODO 11. FavoritesFragment binding
    private lateinit var binding: FragmentFavoritesBinding

    // TODO 12. onCreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO 14. (S) napsat funkci, která
        // TODO - po klikud na tlačtíko -> button.setOnClickListener { }
        // TODO - veme text z TextView
        // TODO - Získá aktuální čas
        // TODO - a spojí předchozí text se získaným časem
        // System.currentTimeMillis()
        // Calendar.getInstance()
        binding.timeButton.setOnClickListener {
            binding.date.text = getTime(binding.date.text.toString())
        }
    }

    private fun getTime(prevText: String): String {
        val timeNow = LocalTime.now().toString()
        return "$prevText $timeNow"
    }

}