package com.example.zapateria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.zapateria.ui.elements.NavGraph
import com.example.zapateria.ui.theme.ZapateriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Si realmente necesitas enableEdgeToEdge, puedes mantenerlo,
        // pero si no lo necesitas, es seguro eliminarlo.
        // enableEdgeToEdge()

        setContent {
            ZapateriaTheme {
                val navController = rememberNavController()  // Crear NavController
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Pasamos el navController al NavGraph
                    NavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
