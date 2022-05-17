package com.example.jetpackcomposetutorial.pages

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun My_WebView() {
    val url = "https://www.netflix.com/in/"

    AndroidView(factory = {
        WebView(it).apply{
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT ,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient() // customize the web view
            loadUrl(url)
        }
    } , update = {
        it.loadUrl(url)
    })

}


@Preview
@Composable
fun InfoPage() {
    My_WebView()

}