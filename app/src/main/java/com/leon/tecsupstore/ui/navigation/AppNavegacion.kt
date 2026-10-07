package com.leon.tecsupstore.ui.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.leon.tecsupstore.ui.components.AppDrawer
import com.leon.tecsupstore.ui.components.BarraSuperior
import com.leon.tecsupstore.ui.screens.PantallaInicio
import kotlinx.coroutines.launch

@Composable
fun AppNavegacion() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { AppDrawer() }
    ) {
        Scaffold(
            topBar = {
                BarraSuperior(
                    titulo = "TECSUP Store",
                    subtitulo = "Mas vendidos",
                    onMenuClick = { scope.launch { drawerState.open() } }
                )
            },
            containerColor = Color.White,
            contentWindowInsets = WindowInsets(0, 0, 0, 0)
        ) { innerPadding ->
            PantallaInicio(modifier = Modifier.padding(innerPadding))
        }
    }
}
