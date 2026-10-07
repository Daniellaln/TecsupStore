package com.leon.tecsupstore.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PantallaPedidos(modifier: Modifier = Modifier) {
    PantallaMensaje(
        titulo = "Mis pedidos",
        detalle = "Aun no tienes pedidos registrados",
        icono = Icons.AutoMirrored.Filled.List,
        modifier = modifier
    )
}
