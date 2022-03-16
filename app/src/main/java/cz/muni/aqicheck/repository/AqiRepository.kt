package cz.muni.aqicheck.repository

import android.content.Context
import cz.muni.aqicheck.data.AqiPresentableListItem
import cz.muni.aqicheck.database.AqiDatabase
import cz.muni.aqicheck.database.FavoriteStationDao
import cz.muni.aqicheck.database.FavoriteStationEntity
import cz.muni.aqicheck.util.getNowFormattedDateString

class AqiRepository(
    context: Context,
    private val favoriteStationDao: FavoriteStationDao = AqiDatabase.create(context).favoriteStationDao(),
) {

    fun getMockedData(count: Int = 10): List<AqiPresentableListItem> =
        mutableListOf<AqiPresentableListItem>().apply {
            repeat(count) {
                val item = AqiPresentableListItem(
                    id = it.toLong(),
                    aqi = "$it",
                    time = System.currentTimeMillis().getNowFormattedDateString(),
                    station = "station-$it",
                    isFavorite = it % 2 == 0,
                )
                if (item.isFavorite) {
                    val entity = FavoriteStationEntity(
                        id = item.id,
                        lastKnownAqi = item.aqi,
                        lastSyncTime = item.time,
                        station = item.station
                    )
                    favoriteStationDao.saveEntity(entity)
                }
                add(item)
            }
        }


    fun getFavorites():List<AqiPresentableListItem> =
        favoriteStationDao.getAll()
            .map{ entity ->
                AqiPresentableListItem(
                    id = entity.id,
                    aqi = entity.lastKnownAqi,
                    time = entity.lastSyncTime,
                    station = entity.station,
                    isFavorite = true
                )
            }

    fun updateFavourite(item: AqiPresentableListItem) {
        val isFavourite = !item.isFavorite
        if (isFavourite) {
            val entity = FavoriteStationEntity(
                id= item.id,
                lastKnownAqi = item.aqi,
                lastSyncTime = item.time,
                station = item.station
            )
            favoriteStationDao.saveEntity(entity)
        } else {
            favoriteStationDao.deleteById(item.id)
        }
    }
}