package com.leon.tecsupstore.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.leon.tecsupstore.ui.navigation.Destino

@Composable
fun AppDrawer(
    onDestinoClick: (Destino) -> Unit,
    onCerrarSesion: () -> Unit
) {
    ModalDrawerSheet {
        Spacer(modifier = Modifier.height(32.dp))
        Destino.values().forEach { destino ->
            NavigationDrawerItem(
                label = { Text(destino.titulo) },
                icon = { Icon(iconoDe(destino), contentDescription = null) },
                selected = false,
                onClick = { onDestinoClick(destino) },
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }
        NavigationDrawerItem(
            label = { Text("Cerrar sesion") },
            icon = { Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null) },
            selected = false,
            onClick = onCerrarSesion,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}

private fun iconoDe(destino: Destino): ImageVector = when (destino) {
    Destino.INICIO -> Icons.Default.Home
    Destino.PEDIDOS -> Icons.AutoMirrored.Filled.List
    Destino.FAVORITOS -> Icons.Default.Favorite
    Destino.PERFIL -> Icons.Default.Person
}
