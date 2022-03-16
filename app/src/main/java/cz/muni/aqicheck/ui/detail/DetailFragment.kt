package cz.muni.aqicheck.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cz.muni.aqicheck.databinding.FragmentListBinding
import cz.muni.aqicheck.repository.AqiRepository
import cz.muni.aqicheck.ui.list.AqiAdapter
import cz.muni.aqicheck.ui.list.ListFragmentDirections
import cz.muni.aqicheck.util.toast

class DetailFragment: Fragment() {

    private lateinit var binding: FragmentListBinding

    // TODO 3.3 inicializace dat
    private val aqiRepository: AqiRepository by lazy {
        AqiRepository()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO 2.1. vytvoření adapteru a předání click listener
        val adapter = AqiAdapter(onItemClick = {
            // TODO 2.2. Toast a kolin extensions
          item -> findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(item))
        })

        // TODO 3.1 layout manager a přiřazení adaptéru
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // TODO 3.2 inicializace dat
        adapter.submitList(aqiRepository.getMockedData(100))
    }
}
// TODO 4.1 Procházka navigation designerem
// TODO 4.1 Vytvoření Action ListFragment
// TODO 4.1 Vytvoření SafeArg DetailFragment

// TODO 4.2 (S) Binding view pros pro DetailFragment