package cz.muni.aqicheck.repository

import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.util.getNowFormattedDateString

class AqiRepository {

    fun getMockedData(count: Int = 10): List<AqiPresentableListItem> =
//        repeat (6)
         mutableListOf<AqiPresentableListItem>().apply {

            repeat(count) {
                val item = AqiPresentableListItem(
                    id = it.toLong(),
                    aqi = "aqi-$it",

                    time = System.currentTimeMillis().getNowFormattedDateString(),
                    station = "station-$it",
                    isFavorite = it % 2 == 0,
                )
                add(item)
            }
        }

}