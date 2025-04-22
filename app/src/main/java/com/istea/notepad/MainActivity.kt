package com.istea.notepad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.istea.notepad.ui.theme.NotePadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            NotePadTheme {
                NavHost(
                    navController = navController,
                    startDestination = "lista"
                ){
                    composable("lista") { ListaDeNotasView(navController) }
                    composable("nueva") { NuevaNota(navController) }
                }
            }
        }
    }
}
