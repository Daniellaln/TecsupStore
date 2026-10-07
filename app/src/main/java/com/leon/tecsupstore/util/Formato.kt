package com.leon.tecsupstore.util

import java.util.Locale

fun formatoSoles(valor: Double): String =
    "S/ " + String.format(Locale.US, "%.2f", valor)
