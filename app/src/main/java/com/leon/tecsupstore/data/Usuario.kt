package com.leon.tecsupstore.data

data class Usuario(val nombre: String, val correo: String) {
    // "Maria Rojas" -> "MR"
    val iniciales: String
        get() = nombre.split(" ")
            .mapNotNull { it.firstOrNull() }
            .take(2)
            .joinToString("")
            .uppercase()
}

val usuarioDemo = Usuario("Maria Rojas", "maria@tecsup.edu.pe")
