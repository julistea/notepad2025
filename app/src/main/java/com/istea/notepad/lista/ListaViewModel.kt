package com.istea.notepad.lista

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.istea.notepad.Nota

class ListaViewModel(
    val navController: NavController,
    val listaDeNotas: List<Nota>,
): ViewModel() {
    var estado by mutableStateOf<ListaEstado>(ListaEstado.Vacio)

    fun ejecutar (intencion: ListaIntencion) {
        when(intencion) {
            ListaIntencion.CargarLista -> cargarLista()
            is ListaIntencion.NotaSeleccionada -> notaSeleccionada(intencion.nota)
            ListaIntencion.NuevaNota -> nuevaNota()
        }
    }

    fun cargarLista() {
        estado = ListaEstado.Resultado(listaDeNotas)
    }

    fun notaSeleccionada(nota: Nota) {
        navController.navigate("detalle/${nota.titulo}")
    }

    fun nuevaNota() {
        navController.navigate("nueva")
    }
}