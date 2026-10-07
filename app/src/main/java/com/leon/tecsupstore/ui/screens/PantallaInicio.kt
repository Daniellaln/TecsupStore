package com.leon.tecsupstore.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.leon.tecsupstore.data.Producto
import com.leon.tecsupstore.data.productosMasVendidos
import com.leon.tecsupstore.ui.components.TarjetaProducto

@Composable
fun PantallaInicio(
    favoritos: List<Int>,
    onToggleFavorito: (Producto) -> Unit,
    onCompartir: (Producto) -> Unit,
    onReportar: (Producto) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(productosMasVendidos) { producto ->
            TarjetaProducto(
                producto = producto,
                esFavorito = favoritos.contains(producto.id),
                onToggleFavorito = { onToggleFavorito(producto) },
                onCompartir = { onCompartir(producto) },
                onReportar = { onReportar(producto) }
            )
        }
    }
}
