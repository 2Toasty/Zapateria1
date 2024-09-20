package com.example.zapateria.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zapateria.model.ShopItem

@Composable
fun ShopListScreen(modifier: Modifier = Modifier, items: List<ShopItem>) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items.size) { index ->
            ShopItemCard(shopItem = items[index])
        }
    }
}
