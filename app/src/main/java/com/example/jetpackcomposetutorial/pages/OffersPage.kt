package com.example.jetpackcomposetutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.Alternative1
import com.example.jetpackcomposetutorial.ui.theme.Alternative2


//@Preview(showBackground = true , widthDp = 400 )
//@Composable
//private fun Offers_Preview(){
//    OffersComposable(title = "My Title ", description = "This is the description")
//}

@Preview(showBackground = true)
@Composable
fun OffersPage() {
    Column(Modifier.verticalScroll(rememberScrollState())
    ) {
        OffersComposable(
            title = "Early Coffee",
            description = "10% off . Offer valid from 6am to 9am"
        )
        OffersComposable(
            title = "Welcome gift",
            description = "20% off on your first order . "
        )
        OffersComposable(
            title = "Early Coffee",
            description = "10% off . Offer valid from 6am to 9am"
        )
    }

}


@Composable
fun OffersComposable(title: String ,  description : String) {

    Box(modifier = Modifier.padding(16.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.background_pattern),
            contentDescription = "Background pattern",
            contentScale = ContentScale.FillWidth ,
            modifier = Modifier
                .matchParentSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = title ,
                style = MaterialTheme.typography.h5 ,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative1)
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = description,
                style = MaterialTheme.typography.h6 ,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative2)
                    .padding(16.dp)
            )
        }
    }


}