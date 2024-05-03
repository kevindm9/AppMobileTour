package edu.unicauca.appeasytour.Model

data class Hotel(
    val nombre: String,
    val precio: String,
    val desayunoIncluido: String,
    val calificacion:Float,
    val imagenId: Int
)

fun HotelEntity.toDomain()=Hotel(nombre,precio,desayunoIncluido,calificacion,imagenId)