package com.example.week7.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.week7.route.listScreen
import com.example.week7.viewmodel.RestaurantListViewModel

@Composable
fun soal1(
    viewModel: RestaurantListViewModel = viewModel(),
    navController: NavController? = null
){

    val modelRestaurant by viewModel.restaurant.collectAsState()

    Column (
        modifier = Modifier
            .padding(top = 40.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
    ){
        Row {
            Text(
                text = "Restaurant List",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        //LazyRow
        LazyColumn (
            modifier = Modifier
                .padding(top = 24.dp)
        ){
            items(modelRestaurant) { restaurant ->
                card1(
                    restaurant,
                    onCardClicked = {navController?.navigate(listScreen.RestaurantInfo.name+"/${restaurant.id}")}
                )
            }

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun viewSoal1(){
    soal1()
}