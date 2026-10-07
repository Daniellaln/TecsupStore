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
import androidx.compose.ui.unit.dp

// Contenido del NavigationDrawer (por ahora los items no navegan)
@Composable
fun AppDrawer() {
    ModalDrawerSheet {
        Spacer(modifier = Modifier.height(32.dp))
        NavigationDrawerItem(
            label = { Text("Inicio") },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            selected = false,
            onClick = { },
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
        NavigationDrawerItem(
            label = { Text("Mis pedidos") },
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = null) },
            selected = false,
            onClick = { },
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
        NavigationDrawerItem(
            label = { Text("Favoritos") },
            icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
            selected = false,
            onClick = { },
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
        NavigationDrawerItem(
            label = { Text("Perfil") },
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            selected = false,
            onClick = { },
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
        NavigationDrawerItem(
            label = { Text("Cerrar sesion") },
            icon = { Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null) },
            selected = false,
            onClick = { },
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}
