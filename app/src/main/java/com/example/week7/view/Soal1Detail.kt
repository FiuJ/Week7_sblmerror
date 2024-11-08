package com.example.week7.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.week7.data.DataSource
import com.example.week7.viewmodel.RestaurantDetailViewModel

@Composable
fun soal1Detail(
    id: Int,
    viewModel: RestaurantDetailViewModel = viewModel()
){

    viewModel.setRestaurant(id)
    val restaurant by viewModel.restaurantDetail.collectAsState()

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 20.dp, end = 20.dp)
    ){
        Text(
            text = "Restaurant Info",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(bottom = 32.dp)
        )
        Text(
            text = restaurant.name,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 12.dp)
        )
        Text(
            text = "⭐ ${restaurant.rating} out of ${restaurant.ratingCount} reviews . ${restaurant.location}",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 12.dp)
        )
        Text(
            text = "Located on ${restaurant.distance} km from your house",
            fontSize = 13.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(color = Color.Gray, RoundedCornerShape(20.dp))
        ){

        }

        Text(
            text = restaurant.description,
            modifier = Modifier
                .padding(bottom = 24.dp, top = 12.dp)
        )

        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CA7F8)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Get Direction",
            )
        }



    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun viewsoal1Detail(){
//    soal1Detail(DataSource().loadSource()[0].id)
}