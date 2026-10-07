package com.leon.tecsupstore.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PantallaFavoritos(modifier: Modifier = Modifier) {
    PantallaMensaje(
        titulo = "Favoritos",
        detalle = "Marca productos desde el menu de 3 puntos",
        icono = Icons.Default.Favorite,
        modifier = modifier
    )
}
