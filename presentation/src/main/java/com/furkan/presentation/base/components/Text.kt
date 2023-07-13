package com.furkan.presentation.base.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun NormalText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Normal,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun BoldText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = Color.Black,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Bold,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun SemiBoldText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = Color.Black
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.SemiBold,
        color = color   ,
        textAlign = textAlign
    )
}

