package cz.muni.aqicheck.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import cz.muni.aqicheck.R
import cz.muni.aqicheck.databinding.FragmentDetailBinding
import kotlin.random.Random

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun Double.format(digits: Int) = "%.${digits}f".format(this)

        val item = DetailFragmentArgs.fromBundle(requireArguments()).item

        binding.aqiTextView.text = item.aqi
        binding.nameTextView.text = item.station
        binding.indicator.backgroundTintList = ContextCompat.getColorStateList(
            requireContext(), when {
                item.aqi.toInt() < 80 -> R.color.aqi_green
                item.aqi.toInt() < 150 -> R.color.aqi_orange
                else -> R.color.aqi_red
            }
        )
        binding.timeTextView.text = item.time
        binding.stationTextView.text = item.station
        binding.webTextView.text = "https://muni.cz"
        binding.locationTextView.text =
            "${Random.nextDouble(-80.0, 80.0).format(5)}, ${
                Random.nextDouble(-120.0, 120.0).format(5)
            }"
    }

}

// TODO 4.2 (S) Binding view pros pro DetailFragment