package com.example.appmovillevelupgamer.datos.repositorio

import com.example.appmovillevelupgamer.datos.servicio.ClienteRetrofit
import com.example.appmovillevelupgamer.dominio.modelo.Producto

class ProductoRepositorio {

    private val api = ClienteRetrofit.api

    // Cuando conectemos backend, usamos esto:
    suspend fun obtenerProductosDesdeApi(): List<Producto> {
        return api.obtenerProductos()
    }

    // Por ahora usamos datos de ejemplo:
    fun obtenerProductosEjemplo(): List<Producto> {
        return listOf(
            Producto(1, "Mouse Gamer RGB", 25000, 10),
            Producto(2, "Teclado Mecánico", 45000, 5),
            Producto(3, "Silla Gamer Pro", 150000, 2)
        )
    }
}
