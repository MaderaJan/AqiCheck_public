package cz.muni.aqicheck.repository

import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.util.getNowFormattedDateString
import kotlin.random.Random

// TODO 4.2 Data layer
class AqiRepository {

    fun getMockedData(count: Int = 20): List<AqiPresentableListItem> {
        return mutableListOf<AqiPresentableListItem>().apply {
            repeat(count) {
                val item = AqiPresentableListItem(
                    it.toLong(),
                    Random.nextInt(0, 500).toString(),
                    System.currentTimeMillis().getNowFormattedDateString(),
                    "station-$it",
                    true
                )
                add(item)
            }
        }
    }
}