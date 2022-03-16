package cz.muni.aqicheck.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cz.muni.aqicheck.R
import cz.muni.aqicheck.databinding.FragmentDetailBinding
import cz.muni.aqicheck.util.AqiScale

class DetailFragment: Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val aqiDetail = DetailFragmentArgs.fromBundle(requireArguments()).item

        binding.aqiTextView.text = aqiDetail.aqi
        binding.timeTextView.text = aqiDetail.time
        binding.locationTextView.text = aqiDetail.station

        val aqiColor = AqiScale.getColor(aqiDetail.aqi)
        binding.indicator.backgroundTintList = ContextCompat.getColorStateList(requireContext(), aqiColor)

        val name = aqiDetail.station
        binding.nameTextView.text = name
        binding.toolbar.title = name

        val station = aqiDetail.station
        binding.stationTextView.text = station
        binding.webTextView.text = station
    }
}