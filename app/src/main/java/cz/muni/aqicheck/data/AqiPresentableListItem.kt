package cz.muni.aqicheck.data


data class AqiPresentableListItem(
    val id: Long,
    val aqi: String,
    val time: String,
    val station: String,
    val isFavorite: Boolean
)