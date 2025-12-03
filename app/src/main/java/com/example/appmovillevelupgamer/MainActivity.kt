package com.example.appmovillevelupgamer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.appmovillevelupgamer.presentacion.AppRoot   // 👈 IMPORTANTE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            Surface(color = MaterialTheme.colorScheme.background) {
                AppRoot(navController)   // ⬅️ YA NO LLAMAMOS DIRECTO A Navegacion
            }
        }
    }
}

