package com.furkan.presentation.base.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun SearchBox(
    placeholder: String,
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit
) {

    val searchText = rememberSaveable {
        mutableStateOf("")
    }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            ),
        singleLine = true,
        value = searchText.value,
        onValueChange = {
            searchText.value = it
            onTextChange(it)
        },
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Black,
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                tint = Color.Black,
                contentDescription = "Search Icon"
            )
        },
        colors = TextFieldDefaults.colors(
            disabledTextColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        shape = CircleShape
    )
}




