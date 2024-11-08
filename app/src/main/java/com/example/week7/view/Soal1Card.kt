package com.example.week7.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week7.R
import com.example.week7.model.Result
import com.example.week7.viewmodel.RestaurantListViewModel

@Composable
fun card1(
    restaurant: Result,
    onCardClicked: () -> Unit
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = onCardClicked
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "picture",
                modifier = Modifier
//                    .size(160.dp)
                    .weight(1f)
                    .clip(RoundedCornerShape(24.dp))
            )
            Column (
                modifier = Modifier
                    .padding(start = 12.dp, top = 24.dp, bottom = 12.dp)
                    .weight(1.5f)
            ){
                Text(
                    text = restaurant.name,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 17.sp,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                )
                Text(
                    text = "⭐ ${restaurant.rating}",
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(vertical = 6.dp)
                )
                Text(
                    text = restaurant.location,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(vertical = 6.dp)
                )
                Text(
                    buildAnnotatedString {
                        withStyle(style = TextStyle(fontWeight = FontWeight.Bold).toSpanStyle()) {
                            append("${restaurant.distance} km ")
                        }
                        append("from your house")
                    },
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(vertical = 6.dp)
                )

            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun viewCard1() {
//    card1( DataSource().loadSource()[1])
}