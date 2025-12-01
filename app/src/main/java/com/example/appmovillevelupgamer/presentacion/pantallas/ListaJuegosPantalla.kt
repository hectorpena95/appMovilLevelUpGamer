package com.example.appmovillevelupgamer.presentacion.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.appmovillevelupgamer.presentacion.viewmodel.ProductoViewModel

@Composable
fun ListaProductosPantalla(
    vm: ProductoViewModel = viewModel()
) {

    // Fondo degradado gamer
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0D1B2A),
                        Color(0xFF1B263B),
                        Color(0xFF415A77)
                    )
                )
            )
            .padding(16.dp)
    ) {

        Column {

            Text(
                text = "🎮 Level Up Gamer",
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFF00E5FF)
            )

            Text(
                text = "Catálogo de Productos",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (vm.cargando) {
                Text("Cargando productos…", color = Color.White)
            }

            vm.error?.let {
                Text("Error: $it", color = Color.Red)
            }

            LazyColumn {
                items(vm.productos) { producto ->
                    ProductoCard(producto = producto)
                }
            }
        }
    }
}

@Composable
fun ProductoCard(producto: com.example.appmovillevelupgamer.dominio.modelo.Producto) {

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E2A47)
        ),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { /* abrir detalle */ }
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Imagen del producto
            AsyncImage(
                model = producto.urlImagen,
                contentDescription = producto.nombre,
                modifier = Modifier
                    .size(85.dp)
                    .background(Color.Black, RoundedCornerShape(10.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = producto.nombre,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF00E5FF)
                )

                Text(
                    text = producto.categoria,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF9BB1C8)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "$${producto.precio}",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFFFFD700)
                )
            }
        }
    }
}
