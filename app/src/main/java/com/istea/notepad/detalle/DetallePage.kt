package com.istea.notepad.detalle

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.istea.notepad.Nota

@Composable
fun DetallePage(
    navController: NavController,
    nota: Nota
) {

    val viewModel = viewModel {
        DetalleViewModel(
            nota,
            navController
        )
    }

    DetalleView(
        Modifier,
        estado = viewModel.estado
    ) {
        intencion ->
        viewModel.ejecutar(intencion)
    }
}