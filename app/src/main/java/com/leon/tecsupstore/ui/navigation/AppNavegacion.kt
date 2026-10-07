package com.leon.tecsupstore.ui.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.leon.tecsupstore.ui.components.AppDrawer
import com.leon.tecsupstore.ui.components.BarraSuperior
import com.leon.tecsupstore.ui.screens.PantallaFavoritos
import com.leon.tecsupstore.ui.screens.PantallaInicio
import com.leon.tecsupstore.ui.screens.PantallaPedidos
import com.leon.tecsupstore.ui.screens.PantallaPerfil
import kotlinx.coroutines.launch

@Composable
fun AppNavegacion() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Destino que se esta mostrando
    var destinoActual by remember { mutableStateOf(Destino.INICIO) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                onDestinoClick = { destino ->
                    destinoActual = destino
                    scope.launch { drawerState.close() }
                },
                onCerrarSesion = { scope.launch { drawerState.close() } }
            )
        }
    ) {
        Scaffold(
            topBar = {
                BarraSuperior(
                    titulo = "TECSUP Store",
                    subtitulo = destinoActual.subtitulo,
                    onMenuClick = { scope.launch { drawerState.open() } }
                )
            },
            containerColor = Color.White,
            contentWindowInsets = WindowInsets(0, 0, 0, 0)
        ) { innerPadding ->
            val contenido = Modifier.padding(innerPadding)
            when (destinoActual) {
                Destino.INICIO -> PantallaInicio(modifier = contenido)
                Destino.PEDIDOS -> PantallaPedidos(modifier = contenido)
                Destino.FAVORITOS -> PantallaFavoritos(modifier = contenido)
                Destino.PERFIL -> PantallaPerfil(modifier = contenido)
            }
        }
    }
}
