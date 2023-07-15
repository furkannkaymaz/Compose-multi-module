package com.furkan.presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.furkan.compose_multi_module.presentation.R
import com.furkan.presentation.base.components.BoldText
import com.furkan.presentation.base.components.SwitchButton

@Composable
fun SettingsRoute(
    modifier: Modifier = Modifier,
    giveMeStarClick: (String) -> Unit,
) {
    SettingsScreen(
        modifier = modifier,
        switchChecked = {
        },
        giveMeStarClick = giveMeStarClick
    )
}

@Composable
fun SettingsScreen(
    modifier: Modifier,
    switchChecked: ((Boolean) -> Unit)?,
    giveMeStarClick: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoldText(text = stringResource(R.string.txt_settings))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BoldText(
                text = "Some Settings",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Start,
            )
            SwitchButton(
                onCheckedChange = switchChecked,
            )
        }
        Button(
            onClick = {
                giveMeStarClick.invoke("https://github.com/furkannkaymaz/Compose-multi-module")
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(R.string.txt_give_me_star))
        }
    }
}