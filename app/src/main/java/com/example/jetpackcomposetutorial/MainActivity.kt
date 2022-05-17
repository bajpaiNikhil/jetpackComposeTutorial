package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataManager =  ViewModelProvider(this)
            .get(DataManager::class.java)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App(dataManager)
//                    Greeting("Android")
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Greeting() {
//    val name = remember{ mutableStateOf("")}
//
//    Column(
//        horizontalAlignment = Alignment
//        .CenterHorizontally ,
//        verticalArrangement = Arrangement
//            .Center
//    ) {
//        App(dataManager)
//    }
//
//}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    JetpackComposeTutorialTheme {
//        Greeting("IamStupid")
//    }
//}