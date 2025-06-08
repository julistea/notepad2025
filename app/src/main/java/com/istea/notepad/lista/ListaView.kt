package com.istea.notepad.lista

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.istea.notepad.Nota
import com.istea.notepad.detalle.DetalleIntencion
import com.istea.notepad.ui.theme.NotePadTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaView(
    estado: ListaEstado,
    onAction: (ListaIntencion) -> Unit
) {

    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        onAction(ListaIntencion.CargarLista)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onAction(ListaIntencion.NuevaNota)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Agregar"
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text("NotePadApp")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding))
        {
            when(estado) {
                ListaEstado.Cargando -> Text("Cargando")
                is ListaEstado.Error -> Text("Error")
                is ListaEstado.Resultado -> ResultadoView(lista = estado.listaDeNotas, onAction = onAction)
                ListaEstado.Vacio -> Text("Vacío")
            }

        }
    }
}

@Composable
fun ResultadoView(modifier: Modifier = Modifier, lista: List<Nota>, onAction: (ListaIntencion) -> Unit) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(15.dp)
    ) {
        items(lista) { nota ->
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            onAction(ListaIntencion.NotaSeleccionada(nota))
                        }
                    )
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .padding(top = 10.dp),
                        text = nota.titulo,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .padding(bottom = 10.dp),
                        text = nota.texto,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Spacer(Modifier.height(15.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun ListaPreview(){
    val list = listOf<Nota>()
    NotePadTheme {
    }
}