package com.example.appmovillevelupgamer.presentacion.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.appmovillevelupgamer.presentacion.viewmodel.ProductoViewModel

@Composable
fun ListaProductosPantalla(
    vm: ProductoViewModel = viewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Catálogo de Productos",
            style = MaterialTheme.typography.headlineMedium
        )

        if (vm.cargando) {
            CircularProgressIndicator()
        }

        vm.error?.let {
            Text("Error: $it", color = MaterialTheme.colorScheme.error)
        }

        LazyColumn {
            items(vm.productos) { producto ->
                ProductoItem(producto)
            }
        }
    }
}

@Composable
fun ProductoItem(producto: com.example.appmovillevelupgamer.dominio.modelo.Producto) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            AsyncImage(
                model = producto.urlImagen,
                contentDescription = producto.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Text(
                text = producto.nombre,
                style = MaterialTheme.typography.titleLarge
            )

            Text(text = producto.descripcion)

            Text(
                text = "Precio: $${producto.precio}",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
