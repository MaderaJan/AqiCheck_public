package cz.muni.aqicheck.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cz.muni.aqicheck.databinding.FragmentFavoritesBinding
import cz.muni.aqicheck.repository.AqiRepository
import cz.muni.aqicheck.ui.list.AqiAdapter

class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding

    private val aqiRepository: AqiRepository by lazy {
        AqiRepository(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AqiAdapter(
            onItemClick = {
                findNavController()
                    .navigate(FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(it.id.toString()))
            }
        )
        adapter.onFavoriteClick = { item, position ->
            aqiRepository.updateFavorite(item)
            adapter.removeItem(position)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        adapter.submitList(aqiRepository.getFavorites())
    }
}