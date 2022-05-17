package com.example.jetpackcomposetutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.pages.InfoPage
import com.example.jetpackcomposetutorial.pages.MenuPage
import com.example.jetpackcomposetutorial.pages.OrderPage
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme


//@Preview
//@Composable
//fun App_Preview() {
//     JetpackComposeTutorialTheme(){
//        App()
//    }
//
//}


@Composable
fun App(dataManager: DataManager) {
    val selectedRoute = remember{
        mutableStateOf( Route.MenuPage.route)
    }
    Scaffold(        
        topBar =  {
            TopAppBar() {
                AppTitle()
            }
        } ,
        content = {
            when (selectedRoute.value){
                Route.OffersPage.route -> OffersPage()
                Route.MenuPage.route -> MenuPage(dataManager)
                Route.OrderPage.route -> OrderPage(dataManager)
                Route.InfoPage.route -> InfoPage()


            }
        },
        bottomBar = {
           NavBar(
               selectedRoute = selectedRoute.value ,
               onChange = { newRoute->
               selectedRoute.value = newRoute
           })
        }
    )
}


@Composable
fun AppTitle() {
    Box(contentAlignment = Alignment.Center
        ,modifier = Modifier
        .fillMaxWidth())
    {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo" )
    }

}