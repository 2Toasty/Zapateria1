package com.example.zapateria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zapateria.ui.theme.ZapateriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZapateriaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Reemplazamos Greeting por ShopListScreen
                    ShopListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ShopListScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(10) { // Cambia 10 por el número de elementos de tu lista
            ShopItemCard(
                imageUrl = "", // Reemplaza con la URL de tu imagen
                title = "Leather boots",
                price = "27,5 $",
                description = "Great warm shoes from the artificial leather. You can buy this model only in our shop"
            )
        }
    }
}

@Composable
fun ShopItemCard(
    imageUrl: String,
    title: String,
    price: String,
    description: String
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            // Imagen de producto
            Image(
                painter = painterResource(id = R.drawable.zapato1), // Usa el identificador de recurso generado automáticamente
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Información del producto
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = price,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Botones de acción
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedButton(onClick = { /* Acción de añadir a favoritos */ }) {
                        Text(text = "Add to favourite")
                    }
                    Button(
                        onClick = { /* Acción de comprar */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF795548))
                    ) {
                        Text(text = "Buy")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShopListScreenPreview() {
    ZapateriaTheme {
        ShopListScreen()
    }
}
