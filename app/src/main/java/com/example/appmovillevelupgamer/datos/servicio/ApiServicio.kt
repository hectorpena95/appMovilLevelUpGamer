package com.example.appmovillevelupgamer.datos.servicio

import com.example.appmovillevelupgamer.dominio.modelo.Producto
import retrofit2.http.GET

interface ApiServicio {

    @GET("productos")
    suspend fun obtenerProductos(): List<Producto>
}
