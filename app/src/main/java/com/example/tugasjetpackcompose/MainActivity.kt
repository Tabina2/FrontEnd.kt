package com.example.tugasjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.tugasjetpackcompose.TopBar
import com.example.tugasjetpackcompose.Screen.DetailScreen
import com.example.tugasjetpackcompose.Screen.HomeScreen
import com.example.tugasjetpackcompose.Screen.ProfileScreen
import com.example.tugasjetpackcompose.Screen.SearchScreen
import com.example.tugasjetpackcompose.navigation.Screen
import com.example.tugasjetpackcompose.ui.theme.TugasJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasJetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        topBar = { TopBar() }
                    ) { innerPadding ->
                        // Pastikan NavHost berada di dalam Scaffold dengan padding yang benar
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Home.route,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(Screen.Home.route) { HomeScreen() }
                            composable(Screen.Search.route) { SearchScreen() }
                            composable(Screen.Profile.route) { ProfileScreen() }
                            composable(
                                route = Screen.Detail.route + "/{title}/{imageResource}/{description}",
                                arguments = listOf(
                                    navArgument("title") { type = NavType.StringType },
                                    navArgument("imageResource") { type = NavType.IntType },
                                    navArgument("description") { type = NavType.StringType }
                                )
                            ) { backStackEntry ->
                                val title = backStackEntry.arguments?.getString("title") ?: "Default Title"
                                val imageResource = backStackEntry.arguments?.getInt("imageResource") ?: R.drawable.verreauxs_eagle
                                val description = backStackEntry.arguments?.getString("description") ?: "Default Description"
                                DetailScreen(
                                    title = title,
                                    imageResource = imageResource,
                                    description = description,
                                    onBackClick = { navController.popBackStack() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}



