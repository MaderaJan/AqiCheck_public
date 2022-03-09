package cz.muni.aqicheck.repository

import cz.muni.aqicheck.data.AqiPresentableListItem

// TODO 4.2 Data layer
class AqiRepository {

    fun getMockedData(count: Int = 10): List<AqiPresentableListItem> {
        val mock = mutableListOf<AqiPresentableListItem>().apply {
            repeat (count) {
                val item = AqiPresentableListItem(
                    id=it.toLong(),
                    aqi="aqi",
                    time="time",
                    station="station-$it",
                    isFavorite= it % 2 == 0,
                )
                add(item)
            }
        }
        return mock
    }
}