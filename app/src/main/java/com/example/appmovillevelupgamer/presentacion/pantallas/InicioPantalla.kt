package com.example.appmovillevelupgamer.presentacion.pantallas

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appmovillevelupgamer.R
import com.example.appmovillevelupgamer.presentacion.viewmodel.ClimaViewModel

@Composable
fun PantallaInicio(
    onExplorarCatalogo: () -> Unit,
    onIniciarSesion: () -> Unit
) {
    val climaVM: ClimaViewModel = viewModel()

    LaunchedEffect(true) {
        climaVM.cargarClima()
    }

    val scaleAnim = rememberInfiniteTransition()
    val scale by scaleAnim.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = EaseInOutCubic),
            repeatMode = RepeatMode.Reverse
        )
    )

    val fondoGamer = Brush.verticalGradient(
        listOf(
            Color(0xFF4500A0),
            Color(0xFF8B00F6),
            Color(0xFF0D0D0D)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(fondoGamer),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            // Logo animado
            Image(
                painter = painterResource(id = R.drawable.logo_levelup),
                contentDescription = "Logo LevelUpGamer",
                modifier = Modifier
                    .size(160.dp)
                    .scale(scale)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // BOTÓN 1
            Button(
                onClick = onExplorarCatalogo,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00E5FF),
                    contentColor = Color.Black
                )
            ) {
                Text("Explorar Catálogo", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // BOTÓN 2
            Button(
                onClick = onIniciarSesion,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF4DFF),
                    contentColor = Color.Black
                )
            ) {
                Text("Iniciar Sesión", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(35.dp))

            // 🔥 SECCIÓN CLIMA
            Text(
                "Clima Actual",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            when {
                climaVM.cargando -> {
                    Text("Cargando clima...", color = Color.White)
                }

                climaVM.error != null -> {
                    Text(
                        text = "Error: ${climaVM.error}",
                        color = Color.Red,
                        fontSize = 16.sp
                    )
                }

                climaVM.clima != null -> {
                    Text(
                        "Temperatura: ${climaVM.clima!!.temperature}°C",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Text(
                        "Viento: ${climaVM.clima!!.windspeed} km/h",
                        color = Color.White
                    )
                }
            }
        }
    }
}
