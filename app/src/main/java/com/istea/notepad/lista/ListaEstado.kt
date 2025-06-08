package com.istea.notepad.lista

import com.istea.notepad.Nota

sealed class ListaEstado {
    data object Vacio: ListaEstado()
    data object Cargando: ListaEstado()
    data class Error(val error: String): ListaEstado()
    data class Resultado(val listaDeNotas: List<Nota>): ListaEstado()
}