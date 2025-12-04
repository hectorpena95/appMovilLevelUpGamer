package com.example.appmovillevelupgamer.navegacion

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import com.example.appmovillevelupgamer.presentacion.pantallas.PantallaInicio
import com.example.appmovillevelupgamer.presentacion.pantallas.ListaProductosPantalla
import com.example.appmovillevelupgamer.presentacion.pantallas.PantallaDetalleProducto
import com.example.appmovillevelupgamer.presentacion.pantallas.CarritoPantalla
import com.example.appmovillevelupgamer.presentacion.login.LoginPantalla
import com.example.appmovillevelupgamer.presentacion.viewmodel.ProductoViewModel
import com.example.appmovillevelupgamer.presentacion.viewmodel.CarritoViewModel

@Composable
fun Navegacion(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    val productosVM: ProductoViewModel = viewModel()
    val carritoVM: CarritoViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "inicio",
        modifier = modifier
    ) {

        composable("inicio") {
            PantallaInicio(
                onExplorarCatalogo = {
                    navController.navigate("productos")
                },
                onIniciarSesion = {
                    navController.navigate("login")
                }
            )
        }

        composable("login") {
            LoginPantalla(
                navController = navController,
                onLoginExitoso = {
                    navController.navigate("productos") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("productos") {
            ListaProductosPantalla(
                navController = navController,
                vm = productosVM
            )
        }

        composable("detalle/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull() ?: -1L
            PantallaDetalleProducto(
                navController = navController,
                productoId = id,
                productosVM = productosVM,
                carritoVM = carritoVM
            )
        }

        composable("carrito") {
            CarritoPantalla(
                navController = navController,
                vm = carritoVM
            )
        }

    }
}
