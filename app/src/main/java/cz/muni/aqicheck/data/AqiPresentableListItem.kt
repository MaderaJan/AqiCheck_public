package cz.muni.aqicheck.data

// TODO 4.1 Data layer
data class AqiPresentableListItem(
    val id: Long,
    val aqi: String,
    val time: String,
    val station: String,
    val isFavorite: Boolean
)