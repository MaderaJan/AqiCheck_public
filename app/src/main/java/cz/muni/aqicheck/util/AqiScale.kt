package cz.muni.aqicheck.util

import cz.muni.aqicheck.R

object AqiScale {

    fun getColor(aqi: String): Int {
        // TODO 2.1 (S) získání barvy na základě aqi hodnoty
        // TODO HODNOTA <= 50 -> R.color.aqi_green
        // TODO HODNOTA <= 100 -> R.color.aqi_yellow
        // TODO HODNOTA <= 150 -> R.color.aqi_orange
        // TODO HODNOTA <= 200 -> R.color.aqi_red
        // TODO HODNOTA <= 300 -> R.color.aqi_purple

        return R.color.aqi_red
    }
}