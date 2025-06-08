package com.istea.notepad.lista

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.istea.notepad.Nota

@Composable
fun ListaPage(
    navController: NavController,
    listaDeNotas: List<Nota>,
) {
    val viewModel = viewModel {
        ListaViewModel(
            navController = navController,
            listaDeNotas = listaDeNotas
        )
    }


    ListaView(
        estado = viewModel.estado
    ) { intencion ->
        viewModel.ejecutar(intencion)
    }
}