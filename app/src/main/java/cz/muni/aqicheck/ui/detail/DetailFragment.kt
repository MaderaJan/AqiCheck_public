package cz.muni.aqicheck.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class DetailFragment: Fragment() {

    // TODO (S) zobrazení view naplněné daty

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aqiItem = DetailFragmentArgs.fromBundle(requireArguments()).item
    }
}