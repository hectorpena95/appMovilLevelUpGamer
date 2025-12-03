package com.example.appmovillevelupgamer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appmovillevelupgamer.navegacion.Navegacion
import com.example.appmovillevelupgamer.ui.theme.AppMovilLevelUpGamerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMovilLevelUpGamerTheme {
                Navegacion()
            }
        }
    }
}
