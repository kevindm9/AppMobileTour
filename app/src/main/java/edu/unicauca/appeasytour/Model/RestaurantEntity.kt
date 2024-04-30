package edu.unicauca.appeasytour.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurantes")
data class RestaurantEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val descripcion: String,
    val rating: Float,
    val imageUrl: Int
)