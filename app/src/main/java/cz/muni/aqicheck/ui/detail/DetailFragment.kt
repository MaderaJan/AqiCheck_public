package cz.muni.aqicheck.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cz.muni.aqicheck.databinding.FragmentDetailBinding

class DetailFragment: Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aqiItem =  DetailFragmentArgs.fromBundle(requireArguments()).item
        binding.aqiTextView.text = aqiItem.aqi
        binding.nameTextView.text = aqiItem.name
        binding.timeTextView.text = aqiItem.time
        binding.stationTextView.text = aqiItem.station
        binding.webTextView.text = aqiItem.web
        binding.locationTextView.text = aqiItem.location
    }
}