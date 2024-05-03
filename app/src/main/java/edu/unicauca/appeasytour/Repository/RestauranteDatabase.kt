package edu.unicauca.appeasytour.Repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.unicauca.appeasytour.Model.IRestauranteDao
import edu.unicauca.appeasytour.Model.RestaurantEntity

@Database(entities = [RestaurantEntity::class], version = 1)
abstract class RestauranteDatabase : RoomDatabase() {

    abstract fun restauranteDao(): IRestauranteDao

    companion object {
        @Volatile
        private var INSTANCE: RestauranteDatabase? = null

        fun getDatabase(context: Context): RestauranteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RestauranteDatabase::class.java,
                    "restaurante_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}