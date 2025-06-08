package com.istea.notepad.detalle

sealed class DetalleIntencion {
    object CargarContenido: DetalleIntencion()
    object IrParaAtras: DetalleIntencion()
}