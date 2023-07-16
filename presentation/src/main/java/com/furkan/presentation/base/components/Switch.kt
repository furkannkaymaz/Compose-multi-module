package com.furkan.presentation.base.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SwitchButton(
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
) {
    val switchChecked = rememberSaveable { mutableStateOf(false) }
    Box(
        modifier = modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {

        Switch(
            checked = switchChecked.value,
            onCheckedChange = {
                switchChecked.value = it
                onCheckedChange?.invoke(it)
            }
        )
    }
}