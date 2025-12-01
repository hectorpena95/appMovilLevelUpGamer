package com.example.appmovillevelupgamer.presentacion.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appmovillevelupgamer.presentacion.viewmodel.ProductoViewModel

@Composable
fun ProductosPantalla(vm: ProductoViewModel = viewModel()) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0A0A))
            .padding(16.dp)
    ) {

        Column {

            Text(
                text = "Catálogo Gamer",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(vm.productos) { prod ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF1A1A1A)
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text(
                                text = prod.nombre,
                                color = Color(0xFF00E676),
                                style = MaterialTheme.typography.headlineSmall
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "$${prod.precio}",
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
