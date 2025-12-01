package com.example.appmovillevelupgamer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.appmovillevelupgamer.navegacion.Navegacion
import com.example.appmovillevelupgamer.ui.theme.AppMovilLevelUpGamerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppMovilLevelUpGamerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Navegacion()
                }
            }
        }
    }
}
