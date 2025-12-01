package com.example.appmovillevelupgamer.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmovillevelupgamer.presentacion.pantallas.PantallaInicio
import com.example.appmovillevelupgamer.presentacion.pantallas.ListaProductosPantalla

@Composable
fun Navegacion() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"   // ← AHORA SÍ parte en la pantalla de inicio
    ) {

        // 🟣 Pantalla de bienvenida
        composable("inicio") {
            PantallaInicio(
                onContinuar = { navController.navigate("catalogo") }
            )
        }

        // 🟦 Catálogo de productos
        composable("catalogo") {
            ListaProductosPantalla()
        }
    }
}
