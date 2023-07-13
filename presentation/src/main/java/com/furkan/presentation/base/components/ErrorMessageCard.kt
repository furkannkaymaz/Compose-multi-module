package com.furkan.presentation.base.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ErrorMessageCard(message: String, icon: ImageVector) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = icon,
                    contentDescription = "Icon",
                    tint = Color.Black,
                    modifier = Modifier.padding(end = 8.dp)
                )
                BoldText(
                    text = message,
                    color = Color.Black,
                )
                Spacer(
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}


