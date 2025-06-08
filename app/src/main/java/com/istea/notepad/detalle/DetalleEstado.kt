package com.istea.notepad.detalle

import com.istea.notepad.Nota

sealed class DetalleEstado {
    data object Vacio: DetalleEstado()
    data object Cargando: DetalleEstado()
    data class Error(val error: String): DetalleEstado()
    data class Resultado(val nota: Nota): DetalleEstado()
}