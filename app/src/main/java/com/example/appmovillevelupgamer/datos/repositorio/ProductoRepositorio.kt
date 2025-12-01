package com.example.appmovillevelupgamer.datos.repositorio

import com.example.appmovillevelupgamer.datos.servicio.ClienteRetrofit
import com.example.appmovillevelupgamer.dominio.modelo.Producto

class ProductoRepositorio {

    private val api = ClienteRetrofit.api

    // 👉 Cuando conectemos al backend
    suspend fun obtenerProductos(): List<Producto> {
        return api.obtenerProductos()
    }

    // 👉 Datos de prueba
    fun productosDeEjemplo(): List<Producto> {
        return listOf(
            Producto(1, "Catan", "Estrategia", 29990, 50, "catan.png", "juegos-de-mesa"),
            Producto(2, "Carcassonne", "Medieval", 24990, 40, "carcassonne.jpg", "juegos-de-mesa"),
            Producto(3, "PS5", "Consola next-gen", 549990, 20, "ps5.jpg", "consolas")
        )
    }
}
