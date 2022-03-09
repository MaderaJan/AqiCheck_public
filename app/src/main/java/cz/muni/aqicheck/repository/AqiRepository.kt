package cz.muni.aqicheck.repository

import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.util.getNowFormattedDateString

class AqiRepository {

    fun getMockedData(count: Int = 10): List<AqiPresentableListItem> =
        mutableListOf<AqiPresentableListItem>().apply {
            repeat(count) {
                val item = AqiPresentableListItem(
                    id = it.toLong(),
                    name = "NAME-$it",
                    aqi = "$it",
                    time = System.currentTimeMillis().getNowFormattedDateString(),
                    station = "station-$it",
                    isFavorite = it % 2 == 0,
                    web = "Url",
                    location = "12.25, 12.25"
                )
                add(item)
            }
        }

}