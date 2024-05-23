package com.example.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.netflix.MovieItemClass
import com.example.netflix.R
import androidx.compose.ui.unit.dp as dp

@Composable
@Preview
fun TopBar(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(top = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ){
        Image(painter = painterResource(id = R.drawable.netflix_logo),
            contentDescription ="netfilx_logo",
            modifier = Modifier
                .padding(2.dp)
                .height(60.dp)
        )
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "search_icon",
                modifier = Modifier.padding(end = 10.dp)
                    .size(30.dp))
            Image(painter = painterResource(id = R.drawable.baseline_account_circle_24),
                contentDescription = "menu_icon",
                modifier = Modifier.padding(end = 10.dp)
                    .size(30.dp))
        }
    }
}

@Composable
@Preview
fun ContentChooser(

){
    Row (
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(45.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "TV Shows",
            color = Color.Gray)
        Text(text = "Movies",
            color = Color.Gray)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Categories",
                color = Color.Gray)
            Image(painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                contentDescription = "option_logo")
        }
    }
}

@Composable
@Preview
fun FeaturedSection(
    image: Int = R.drawable.img_4
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
//                .height(500.dp)
            .background(Color.Black)
            .padding(vertical = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = image),
            contentDescription = "mid_popster",
            modifier = Modifier.size(300.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Action",
                color = Color.Gray,
                fontSize = 16.sp)
            Image(painter = painterResource(id = R.drawable.dot_gray),
                contentDescription = "dot_logo")
            Text(text = "Thriller",
                color = Color.Gray,
                fontSize = 16.sp)
            Image(painter = painterResource(id = R.drawable.dot_gray),
                contentDescription = "dot_logo")
            Text(text = "Crime",
                color = Color.Gray,
                fontSize = 16.sp)
            Image(painter = painterResource(id = R.drawable.dot_gray),
                contentDescription = "dot_logo")
            Text(text = "Adventure",
                color = Color.Gray,
                    fontSize = 16.sp)
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = "add_logo")
                Text(
                    text = "My List", color = Color.Gray,
                    fontSize = 18.sp
                )
            }
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "Play",
                    color = Color.Black,
                    fontSize = 18.sp)
            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.info_gray),
                    contentDescription = "info_logo")
                Text(text = "info",
                    color = Color.Gray,
                    fontSize = 18.sp)
            }
        }
    }
}

    @Composable
    fun MovieItemUiModel(
        imgRes: Int
    ){
        Image(painter = painterResource(id = imgRes),
            contentDescription = "",
            modifier = Modifier
                .height(180.dp)
                .width(140.dp))
    }

    @Composable
//    @Preview
    fun Movies(
        movieCategory : String ,
        list: List<MovieItemClass>
    ){
        Column (
            modifier = Modifier.padding(top = 8.dp, start = 8.dp)
        ){
            Text(text = movieCategory,
                    color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier.padding(start = 12.dp, bottom = 8.dp))
            LazyRow {
                itemsIndexed(list){
                    index, item-> MovieItemUiModel(imgRes = item.image)
                }
            }
        }


    }







