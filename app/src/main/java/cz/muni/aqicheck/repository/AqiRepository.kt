package cz.muni.aqicheck.repository

import cz.muni.aqicheck.data.AqiPresentableListItem

// TODO 4.2 Data layer
class AqiRepository {

    fun getMockedData(count: Int = 10): List<AqiPresentableListItem> =
//        repeat (6)
         mutableListOf<AqiPresentableListItem>().apply {
            repeat(count) {
                val item = AqiPresentableListItem(
                    id = it.toLong(),
                    aqi = "aqi-$it",
                    time = "$it.02.2022",
                    station = "aqi-station$it",
                    isFavorite = it % 2 == 0

                )
            }
        }
}