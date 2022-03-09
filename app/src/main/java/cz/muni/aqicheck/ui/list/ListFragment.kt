package cz.muni.aqicheck.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cz.muni.aqicheck.databinding.FragmentListBinding
import cz.muni.aqicheck.repository.AqiRepository
import cz.muni.aqicheck.util.toast

class ListFragment : Fragment() {

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
            context?.toast("${it.station}")
        })

<<<<<<< HEAD


        // TODO 12. layout manager a přiřazení adaptéru
=======
        // TODO 3.1 layout manager a přiřazení adaptéru
>>>>>>> origin
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // TODO 3.2 inicializace dat
    }
}