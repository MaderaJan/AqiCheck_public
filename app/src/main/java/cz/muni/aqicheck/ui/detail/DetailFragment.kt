package cz.muni.aqicheck.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import cz.muni.aqicheck.R

class DetailFragment: Fragment(R.layout.fragment_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = DetailFragmentArgs.fromBundle(requireArguments()).item
    }
}


// TODO 4.2 (S) Binding view pros pro DetailFragment