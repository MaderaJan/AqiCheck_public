package cz.muni.aqicheck.util

import cz.muni.aqicheck.R

object AqiScale {

    fun getColor(aqi: String): Int =
        try {
            val aqiInt = aqi.toInt()

            when {
                aqiInt <= 50 -> R.color.aqi_green
                aqiInt <= 100 -> R.color.aqi_yellow
                aqiInt <= 150 -> R.color.aqi_orange
                aqiInt <= 200 -> R.color.aqi_red
                aqiInt <= 300 -> R.color.aqi_purple
                else -> R.color.aqi_red
            }
        } catch (ex: Exception) {
            R.color.aqi_red
        }
}