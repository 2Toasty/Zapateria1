package com.example.zapateria.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController) {
    var selectedSize by remember { mutableStateOf("") }
    var productCount by remember { mutableStateOf("") }
    var isDropdownExpanded by remember { mutableStateOf(false) }

    val sizes = listOf("Small", "Medium", "Large") // Opciones de tamaños

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Select Product Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                // Selección de tamaño
                Text("Select size", style = MaterialTheme.typography.titleMedium)
                ExposedDropdownMenuBox(
                    expanded = isDropdownExpanded,
                    onExpandedChange = { isDropdownExpanded = !isDropdownExpanded }
                ) {
                    TextField(
                        value = selectedSize,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Size") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropdownExpanded)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor()
                    )
                    ExposedDropdownMenu(
                        expanded = isDropdownExpanded,
                        onDismissRequest = { isDropdownExpanded = false }
                    ) {
                        sizes.forEach { size ->
                            DropdownMenuItem(
                                text = { Text(size) },
                                onClick = {
                                    selectedSize = size
                                    isDropdownExpanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Campo para ingresar la cantidad
                Text("Enter product quantity", style = MaterialTheme.typography.titleMedium)
                OutlinedTextField(
                    value = productCount,
                    onValueChange = { productCount = it },
                    label = { Text("Quantity") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Botones
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Text("Back")
                }
                Button(
                    onClick = {
                        // Lógica de compra aquí
                    }
                ) {
                    Text("Buy")
                }
            }
        }
    }
}
