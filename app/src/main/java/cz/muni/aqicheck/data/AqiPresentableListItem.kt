package cz.muni.aqicheck.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AqiPresentableListItem(
    val id: Long,
    val name: String,
    val aqi: String,
    val time: String,
    val station: String,
    val location: String,
    val web: String,
    val isFavorite: Boolean
) : Parcelable