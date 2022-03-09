package cz.muni.aqicheck.repository

import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.util.getNowFormattedDateString
import kotlin.random.Random

class AqiRepository {

    private var _last: List<AqiPresentableListItem> = listOf()

    fun getMockedData(count: Int = 20): List<AqiPresentableListItem> {

        if (_last.size == count) {
            return _last.toMutableList()
        } else {
            _last = mutableListOf<AqiPresentableListItem>().apply {
                repeat(count) {
                    val item = AqiPresentableListItem(
                        id = it.toLong(),
                        aqi = Random.nextInt(0, 500).toString(),
                        time = System.currentTimeMillis().getNowFormattedDateString(),
                        station = "station-$it",
                        isFavorite = Random.nextBoolean(),
                    )
                    add(item)
                }
            }
            return _last
        }
    }

}