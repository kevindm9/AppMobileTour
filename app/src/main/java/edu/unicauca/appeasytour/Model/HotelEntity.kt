package edu.unicauca.appeasytour.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HotelEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val precio: String,
    val desayunoIncluido: String,
    val calificacion:String,
    val imagenId: Int
)
