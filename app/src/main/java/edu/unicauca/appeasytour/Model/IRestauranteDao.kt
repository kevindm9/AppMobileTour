package edu.unicauca.appeasytour.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IRestauranteDao {
    @Query("SELECT * FROM restaurantes")
    suspend fun getAllRestaurantes(): List<RestaurantEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurante(restaurante: RestaurantEntity)

}