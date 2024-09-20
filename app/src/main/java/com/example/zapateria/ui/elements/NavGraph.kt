package com.example.zapateria.ui.elements

import ShopListScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zapateria.model.ShopItem

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "shop_list_screen",  // Rutas en minúsculas y con guiones bajos
        modifier = modifier
    ) {
        composable("shop_list_screen") {
            // Llamar a la pantalla de lista de productos
            ShopListScreen(navController = navController, items = listOf(
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
            ))
        }
        composable("product_detail_screen") {
            // Llamar a la pantalla de detalle del producto
            ProductDetailScreen(navController = navController)
        }
    }
}
