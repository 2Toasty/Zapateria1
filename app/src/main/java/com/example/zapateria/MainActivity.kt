package com.example.zapateria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.example.zapateria.model.ShopItem
import com.example.zapateria.ui.elements.ShopListScreen
import com.example.zapateria.ui.theme.ZapateriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZapateriaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShopListScreen(
                        modifier = Modifier.padding(innerPadding),
                        items = listOf(
                            ShopItem(
                                imageUrl = "image_url_1",
                                title = "Leather boots",
                                price = "27,5 $",
                                description = "Great warm shoes from artificial leather."
                            ),
                            ShopItem(
                                imageUrl = "image_url_2",
                                title = "Sneakers",
                                price = "30,0 $",
                                description = "Comfortable and stylish sneakers for daily wear."
                            )
                        )
                    )
                }
            }
        }
    }
}
