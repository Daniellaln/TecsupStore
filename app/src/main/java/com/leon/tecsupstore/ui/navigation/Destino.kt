package com.leon.tecsupstore.ui.navigation

// Destinos del drawer. El subtitulo se muestra en la barra superior
enum class Destino(val titulo: String, val subtitulo: String) {
    INICIO("Inicio", "Mas vendidos"),
    PEDIDOS("Mis pedidos", "Tus compras"),
    FAVORITOS("Favoritos", "Lo que te gusto"),
    PERFIL("Perfil", "Tu cuenta")
}
