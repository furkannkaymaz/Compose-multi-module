package com.furkan.presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.furkan.presentation.base.components.BoldText
import com.furkan.presentation.base.components.SwitchButton

@Composable
fun SettingsRoute(
    modifier: Modifier = Modifier,
) {
    SettingsScreen(
        modifier = modifier,
        switchChecked = {

        }
    )
}

@Composable
fun SettingsScreen(
    modifier: Modifier,
    switchChecked: ((Boolean) -> Unit)?
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BoldText(
                text = "Change Theme",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Start,
            )
            SwitchButton(
                onCheckedChange = switchChecked,
            )
        }
    }
}