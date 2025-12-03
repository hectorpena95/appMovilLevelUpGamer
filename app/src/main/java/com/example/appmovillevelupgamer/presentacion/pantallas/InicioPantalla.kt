package com.example.appmovillevelupgamer.presentacion.pantallas

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.example.appmovillevelupgamer.R

@Composable
fun PantallaInicio(
    onContinuar: () -> Unit
) {
    // Animación de "latido"
    val scaleAnim = rememberInfiniteTransition()
    val scale by scaleAnim.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = EaseInOutCubic),
            repeatMode = RepeatMode.Reverse
        )
    )

    // Fondo degradado gamer
    val fondoGamer = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF4500A0), // púrpura intenso
            Color(0xFF8B00F6), // violeta neón
            Color(0xFF0D0D0D)  // negro
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
            modifier = Modifier.padding(24.dp)
        ) {

            // LOGO O IMAGEN
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(160.dp)
                    .scale(scale) // animación
            )

            Spacer(modifier = Modifier.height(24.dp))

            // TÍTULO
            Text(
                text = "LEVEL UP GAMER",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            // SUBTÍTULO
            Text(
                text = "Tu tienda gamer definitiva",
                fontSize = 18.sp,
                color = Color(0xFFFFD2FA)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // BOTÓN GAMER
            Button(
                onClick = onContinuar,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00E5FF), // cian neón
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(50.dp)
            ) {
                Text(
                    text = "Entrar al Catálogo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
