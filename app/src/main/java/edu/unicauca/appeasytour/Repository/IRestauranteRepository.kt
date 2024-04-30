package edu.unicauca.appeasytour.Repository

import edu.unicauca.appeasytour.Model.RestaurantEntity

interface IRestauranteRepository {
    suspend fun getAllRestaurantes(): List<RestaurantEntity>
    suspend fun insertRestaurante(restaurante: RestaurantEntity)
}