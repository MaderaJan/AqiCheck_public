package cz.muni.aqicheck.repository

import android.content.Context
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.database.AqiDatabase
import cz.muni.aqicheck.database.FavoriteStationDao
import cz.muni.aqicheck.util.getNowFormattedDateString

class AqiRepository(
    context: Context,
    // TODO 7. Vytvoření databáze
    private val favoriteStationDao: FavoriteStationDao = AqiDatabase.create(context).favoriteStationDao(),
) {

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


    fun getFavorites() {
        // TODO 8. napsat získání favorites a mapování na list entity
    }
}