package com.example.appmovillevelupgamer.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmovillevelupgamer.presentacion.pantallas.PantallaInicio
import com.example.appmovillevelupgamer.presentacion.pantallas.ListaProductosPantalla
import com.example.appmovillevelupgamer.presentacion.login.LoginPantalla

@Composable
fun Navegacion() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        // 🟣 LOGIN
        composable("login") {
            LoginPantalla(
                onLoginExitoso = {
                    navController.navigate("inicio") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        // 🟦 Pantalla de inicio
        composable("inicio") {
            PantallaInicio(
                onContinuar = { navController.navigate("catalogo") }
            )
        }

        // 🟩 Catálogo
        composable("catalogo") {
            ListaProductosPantalla()
        }
    }
}

