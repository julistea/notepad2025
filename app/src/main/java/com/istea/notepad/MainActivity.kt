package com.istea.notepad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.istea.notepad.detalle.DetallePage
import com.istea.notepad.detalle.DetalleView

import com.istea.notepad.ui.theme.NotePadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {

            NotePadTheme {
                val navController = rememberNavController()
                val listaDeNotas = remember { mutableStateListOf<Nota>() }
                NavHost(
                    navController = navController,
                    startDestination = "lista"
                ){
                    composable("lista") {
                        ListaDeNotasView(
                            navController,
                            listaDeNotas
                        )
                    }
                    composable("nueva") {
                        NuevaNota(navController){ nota ->
                            listaDeNotas.add(nota)
                        }
                    }
                    composable("detalle/{titulo}") { backStack ->
                        val titulo = backStack.arguments?.getString("titulo")
                        val nota = listaDeNotas.first { nota ->
                            nota.titulo == titulo
                        }
                        DetallePage(navController = navController, nota)
                    }
                }
            }
        }
    }
}
