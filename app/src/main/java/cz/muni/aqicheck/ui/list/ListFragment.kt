package cz.muni.aqicheck.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cz.muni.aqicheck.databinding.FragmentListBinding
import cz.muni.aqicheck.repository.AqiRepository
import cz.muni.aqicheck.util.toast

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val aqiRepository: AqiRepository by lazy {
        AqiRepository(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AqiAdapter(
            onItemClick = {
                findNavController()
                    .navigate(ListFragmentDirections.actionListFragmentToDetailFragment(it.id.toString()))
            },
        )
        adapter.onFavoriteClick = { item, position ->
            aqiRepository.updateFavorite(item)
            adapter.updateFavorite(position, !item.isFavorite)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        aqiRepository.search(
            keyword = "czech",
            onSuccess = { items ->
                adapter.submitList(items)
            }, onFailure = { error ->
                context?.toast("Something happened!")
            })
    }
}