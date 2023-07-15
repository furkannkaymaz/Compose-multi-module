package com.furkan.presentation.base.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.furkan.presentation.ui.theme.bottomNavColor

@Composable
fun TopContent(
    modifier: Modifier = Modifier,
    onBackPressed: (() -> Unit)? = null,
    showIconButton: Boolean = true,
    showHeader: Boolean = true,
    headerTitle: String = ""
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(bottomNavColor)
            .height(56.dp)
            .padding(top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showIconButton && onBackPressed != null) {
            IconButton(
                onClick = onBackPressed,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    tint = Color.White,
                    contentDescription = "Back"
                )
            }
        }

        if (showHeader) {
            BoldText(
                text = headerTitle,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
        }
    }
}