package com.example.appmovillevelupgamer.presentacion.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmovillevelupgamer.datos.repositorio.ProductoRepositorio
import com.example.appmovillevelupgamer.dominio.modelo.Producto
import kotlinx.coroutines.launch

class ProductoViewModel(
    private val repo: ProductoRepositorio = ProductoRepositorio()
) : ViewModel() {

    var productos by mutableStateOf<List<Producto>>(emptyList())
        private set

    var cargando by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    init {
        cargarProductos()
    }

    fun cargarProductos() {
        viewModelScope.launch {
            try {
                cargando = true
                productos = repo.obtenerProductos()
            } catch (e: Exception) {
                error = e.message
            } finally {
                cargando = false
            }
        }
    }
}
