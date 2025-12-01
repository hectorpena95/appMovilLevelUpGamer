package com.example.appmovillevelupgamer.presentacion.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appmovillevelupgamer.presentacion.viewmodel.ProductoViewModel

@Composable
fun ProductosPantalla(vm: ProductoViewModel = viewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Productos Level Up Gamer",
            style = MaterialTheme.typography.headlineLarge
        )

        if (vm.cargando) {
            Text("Cargando productos…")
        }

        vm.error?.let {
            Text("Error: $it", color = MaterialTheme.colorScheme.error)
        }

        LazyColumn {
            items(vm.productos) { producto ->
                Text(
                    text = "${producto.nombre} - $${producto.precio} (Stock: ${producto.stock})",
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}
