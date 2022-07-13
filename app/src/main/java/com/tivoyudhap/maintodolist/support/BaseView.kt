package com.tivoyudhap.maintodolist.support

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.tivoyudhap.maintodolist.ui.theme.Purple500

@Composable
fun appBar(title: String, onClick: () -> Unit): @Composable () -> Unit = {
    TopAppBar(backgroundColor = Purple500) {
        Row {
            Button(onClick = onClick) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f),
                fontSize = 15f.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}