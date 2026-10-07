package com.leon.tecsupstore.ui.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.leon.tecsupstore.data.Producto
import com.leon.tecsupstore.data.usuarioDemo
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
    val snackbarHostState = remember { SnackbarHostState() }

    var destinoActual by remember { mutableStateOf(Destino.INICIO) }

    // Los favoritos viven aqui (arriba de todo): por eso el badge del drawer
    // y las tarjetas ven siempre el mismo dato
    val favoritos = remember { mutableStateListOf<Int>() }

    fun toggleFavorito(producto: Producto) {
        if (favoritos.contains(producto.id)) {
            favoritos.remove(producto.id)
        } else {
            favoritos.add(producto.id)
        }
    }

    fun avisar(mensaje: String) {
        scope.launch { snackbarHostState.showSnackbar(mensaje) }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                usuario = usuarioDemo,
                destinoActual = destinoActual,
                cantidadFavoritos = favoritos.size,
                onDestinoClick = { destino ->
                    destinoActual = destino
                    scope.launch { drawerState.close() }
                },
                onCerrarSesion = {
                    scope.launch { drawerState.close() }
                    avisar("Sesion cerrada")
                }
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
            snackbarHost = { SnackbarHost(snackbarHostState) },
            containerColor = Color.White,
            contentWindowInsets = WindowInsets(0, 0, 0, 0)
        ) { innerPadding ->
            val contenido = Modifier.padding(innerPadding)
            when (destinoActual) {
                Destino.INICIO -> PantallaInicio(
                    favoritos = favoritos,
                    onToggleFavorito = { toggleFavorito(it) },
                    onCompartir = { avisar("Compartiendo ${it.nombre}") },
                    onReportar = { avisar("Producto reportado: ${it.nombre}") },
                    modifier = contenido
                )
                Destino.PEDIDOS -> PantallaPedidos(modifier = contenido)
                Destino.FAVORITOS -> PantallaFavoritos(
                    favoritos = favoritos,
                    onToggleFavorito = { toggleFavorito(it) },
                    onCompartir = { avisar("Compartiendo ${it.nombre}") },
                    onReportar = { avisar("Producto reportado: ${it.nombre}") },
                    modifier = contenido
                )
                Destino.PERFIL -> PantallaPerfil(modifier = contenido)
            }
        }
    }
}
