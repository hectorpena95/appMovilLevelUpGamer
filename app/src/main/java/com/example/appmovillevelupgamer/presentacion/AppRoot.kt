package com.example.appmovillevelupgamer.presentacion

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appmovillevelupgamer.navegacion.Navegacion

@Composable
fun AppRoot(navController: NavHostController) {

    val items = listOf(
        BottomItem("inicio", Icons.Default.Home),
        BottomItem("productos", Icons.Default.List),
        BottomItem("carrito", Icons.Default.ShoppingCart),
        BottomItem("login", Icons.Default.Person)
    )

    val selectedColor = Color(0xFF00E5FF)
    val unselectedColor = Color(0xFF777777)
    val barColor = Color(0xFF141414)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = barColor) {
                items.forEach { item ->
                    val selected = currentRoute == item.route

                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo("inicio") { inclusive = false }
                            }
                        },
                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = null,
                                tint = if (selected) selectedColor else unselectedColor
                            )
                        }
                    )
                }
            }
        }
    ) { padding ->
        Navegacion(
            navController = navController,
            modifier = Modifier.padding(padding)
        )
    }
}


data class BottomItem(
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)
