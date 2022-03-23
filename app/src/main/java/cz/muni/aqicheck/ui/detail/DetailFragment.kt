package cz.muni.aqicheck.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cz.muni.aqicheck.R
import cz.muni.aqicheck.databinding.FragmentDetailBinding
import cz.muni.aqicheck.repository.AqiRepository
import cz.muni.aqicheck.util.AqiScale
import cz.muni.aqicheck.util.toast

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val aqiRepository: AqiRepository by lazy {
        AqiRepository(requireContext())
    }

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

        val id = DetailFragmentArgs.fromBundle(requireArguments()).id
        aqiRepository.getStationById(id.toLong(),
            onSuccess = { aqiDetail ->
                binding.aqiTextView.text = aqiDetail.data.aqi
                binding.timeTextView.text = aqiDetail.data.time.s
                binding.locationTextView.text = aqiDetail.data.city.geo.joinToString(", ")

                val aqiColor = AqiScale.getColor(aqiDetail.data.aqi)
                binding.indicator.backgroundTintList = ContextCompat.getColorStateList(requireContext(), aqiColor)

                val name = aqiDetail.data.city.name
                binding.nameTextView.text = name
                binding.toolbar.title = name

                binding.stationTextView.text = aqiDetail.data.attributions.joinToString(", ") { it.name }
                binding.webTextView.text = aqiDetail.data.city.url
            }, onFailure = {
                context?.toast("😶😶😶😶😶")
            })
    }
}