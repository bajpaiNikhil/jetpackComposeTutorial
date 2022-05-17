package com.example.jetpackcomposetutorial.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.jetpackcomposetutorial.DataManager
import com.example.jetpackcomposetutorial.Product
import com.example.jetpackcomposetutorial.R
import com.example.jetpackcomposetutorial.ui.theme.Alternative1
import com.example.jetpackcomposetutorial.ui.theme.CardBackground
import com.example.jetpackcomposetutorial.ui.theme.Primary

@Composable
fun MenuPage(dataManager: DataManager) {
    LazyColumn{
        items(dataManager.menu){
            Text(
                it.name ,
                color = Primary ,
                modifier = Modifier.padding(10.dp , 20.dp  , 10.dp , 10.dp)
            )
            it.products.forEach{
                Card(
                    elevation = 10.dp ,
                    shape = RoundedCornerShape(12.dp) ,
                    modifier = Modifier
                        .background(CardBackground)
                        .padding(12.dp) ,
                ) {
                    ProductItem(it , onAdd = {
                        dataManager.cartAdd(it)
                    })
                }
            }
        }
    }
}


fun Double.format(digits: Int) = "%.${digits}f".format(this)

//@Preview
//@Composable
//fun ProductItem_Preview() {
//    ProductItem(product = Product(1, "Dummy", 1.25, ""), onAdd = {})
//}

@Composable
fun ProductItem(product: Product, onAdd: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Image for ${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
//        Image(
//            painter = painterResource(id = R.drawable.black_coffee),
//            contentDescription = "back coffee",
//            contentScale = ContentScale.FillWidth,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(180.dp)
//
//        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("$${product.price.format(2)} ea")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Alternative1,
                    contentColor = Color.White
                ),
                onClick = {
                    onAdd(product)
                },
            ) {
                Text("Add")
            }
        }
    }
}