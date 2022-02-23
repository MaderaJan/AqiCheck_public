package cz.muni.aqicheck.ui.favorites

import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import cz.muni.aqicheck.databinding.FragmentFavoritesBinding
import java.text.SimpleDateFormat
import java.util.*

class FavoritesFragment : Fragment() {

    // TODO 11. FavoritesFragment binding
    private lateinit var binding: FragmentFavoritesBinding
    private val formatter = SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z", Locale.US)

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
        binding.favoritesButton.setOnClickListener {
            binding.timeView.text = getTime(binding.timeView.text.toString())
        }
        binding.textInput.addTextChangedListener { text ->
            binding.timeView.text = getTime(text.toString())
        }
        binding.textInput.setOnKeyListener { v, keyCode, event ->

            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                val inputManager: InputMethodManager =
                    requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(
                    binding.textInput.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
                binding.textInput.clearFocus()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }

    private fun getTime(text: String): String {
        val date = Date(System.currentTimeMillis())
        return "$text,\n ${formatter.format(date)}"
    }
}