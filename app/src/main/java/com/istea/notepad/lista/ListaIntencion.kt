package com.istea.notepad.lista

import com.istea.notepad.Nota

sealed class ListaIntencion {
    object CargarLista: ListaIntencion()
    object NuevaNota: ListaIntencion()
    class NotaSeleccionada(val nota: Nota): ListaIntencion()
}