package com.example.tugasjetpackcompose

import androidx.compose.foundation.layout.Row
import com.example.tugasjetpackcompose.Screen.HomeScreen
import com.example.tugasjetpackcompose.Screen.SearchScreen
import com.example.tugasjetpackcompose.Screen.ProfileScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.tugasjetpackcompose.Screen.HomeScreen
import com.example.tugasjetpackcompose.Screen.ProfileScreen
import com.example.tugasjetpackcompose.Screen.SearchScreen
import com.example.tugasjetpackcompose.navigation.Screen
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.tugasjetpackcompose.Screen.DetailScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {

    val navController = rememberNavController()

    val navItemList = listOf(
        NavItem("Home", Icons.Filled.Home),
        NavItem("Search", Icons.Filled.Search),
        NavItem("Profile", Icons.Filled.AccountCircle)
    )

    var selectedIndex by remember { mutableStateOf(0) }

    val screenTitle = when (selectedIndex) {
        0 -> "Home"
        1 -> "Search"
        2 -> "Profile"
        else -> "Home"
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.bird),
                            contentDescription = "Logo Icon",
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 7.dp)
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(text = screenTitle)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors()
            )
        },
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index
                            when (index) {
                                0 -> navController.navigate(Screen.Home.route)
                                1 -> navController.navigate(Screen.Search.route)
                                2 -> navController.navigate(Screen.Profile.route)
                            }
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "Icon")
                        },
                        label = {
                            Text(text = navItem.name)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    onItemClick = { name, image, description ->
                        navController.navigate(
                            Screen.Detail.createRoute(name, image, description)
                        )
                    }
                )
            }
            composable(Screen.Search.route) { SearchScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                    navArgument("image") { type = NavType.IntType },
                    navArgument("description") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: ""
                val image = backStackEntry.arguments?.getInt("image") ?: 0
                val description = backStackEntry.arguments?.getString("description") ?: ""

                DetailScreen(
                    title = name,
                    imageResource = image,
                    description = description,
                    onBackClick = { navController.navigateUp() }
                )
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Text("Home Screen")
}

@Composable
fun SearchScreen() {
    Text("Search Screen")
}

@Composable
fun ProfileScreen() {
    Text("Profile Screen")
}

@Preview(showBackground = true)
@Composable
fun PreviewNavBar() {
    TopBar()
}