package cz.muni.aqicheck.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [FavoriteStationEntity::class],
    version = 1
)
abstract class AqiDatabase : RoomDatabase() {

    companion object {
        private const val NAME = "aqi-mock.db"

        fun create(context: Context): AqiDatabase =
            Room.databaseBuilder(context, AqiDatabase::class.java, NAME)
                .allowMainThreadQueries()
                .build()
    }

    abstract fun favoriteStationDao(): FavoriteStationDao
}