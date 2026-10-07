package com.leon.tecsupstore.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PantallaPerfil(modifier: Modifier = Modifier) {
    PantallaMensaje(
        titulo = "Perfil",
        detalle = "Datos de tu cuenta TECSUP Store",
        icono = Icons.Default.Person,
        modifier = modifier
    )
}
