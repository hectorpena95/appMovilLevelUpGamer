package com.example.appmovillevelupgamer.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmovillevelupgamer.presentacion.pantallas.ProductosPantalla

@Composable
fun Navegacion() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "productos"
    ) {
        composable("productos") { ProductosPantalla() }
    }
}
