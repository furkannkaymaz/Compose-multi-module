package com.furkan.presentation.web_view

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebScreenRoute(
    url: String
) {
    WebScreen(
        url = url
    )
}

@Composable
fun WebScreen(url: String) {
    Box(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()) {
            AndroidView(factory = { context ->
                WebView(context).apply {
                    webViewClient = WebViewClient()
                    loadUrl(url)
                }
            })
    }
}