package com.example.week7.route

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.week7.view.soal1
import com.example.week7.view.soal1Detail

enum class listScreen(){
    RestaurantList,
    RestaurantInfo
}

@Composable
fun AppRouting(){

    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = listScreen.RestaurantList.name,
            modifier = androidx.compose.ui.Modifier.padding(innerPadding)
        ){
            composable(route = listScreen.RestaurantList.name) {
                soal1(navController = navController)
            }
            composable(route = listScreen.RestaurantInfo.name+"/{id}",
                arguments = listOf(
                    navArgument("id"){type = NavType.IntType}
                )
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getInt("id")
                soal1Detail(id!!)
            }
        }

    }
}