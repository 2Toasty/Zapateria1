import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zapateria.R  // Asegúrate de importar R para los recursos
import com.example.zapateria.model.ShopItem

@Composable
fun ShopListScreen(navController: NavController, items: List<ShopItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items.size) { index ->
            val item = items[index]
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    // Cargar la imagen local desde drawable
                    Image(
                        painter = painterResource(id = R.drawable.zapato1),  // Imagen local desde drawable
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Mostrar la información del producto
                    Text(text = item.title, style = MaterialTheme.typography.titleLarge)
                    Text(text = item.price, style = MaterialTheme.typography.bodyLarge)
                    Text(text = item.description, style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(8.dp))

                    // Botón para comprar
                    Button(
                        onClick = {
                            // Navegar a la pantalla de detalle del producto
                            navController.navigate("product_detail_screen")
                        }
                    ) {
                        Text("Buy")
                    }

                    // Botón para agregar a favoritos
                    OutlinedButton(onClick = {
                        // Acción de agregar a favoritos
                    }) {
                        Text("Add to Favourites")
                    }
                }
            }
        }
    }
}
