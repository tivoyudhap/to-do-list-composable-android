package com.tivoyudhap.maintodolist.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.tivoyudhap.maintodolist.support.appBar
import com.tivoyudhap.maintodolist.viewmodel.CreateToDoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateToDoActivity : ComponentActivity() {

    private val viewModel: CreateToDoViewModel by lazy { ViewModelProvider(this)[CreateToDoViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(topBar = appBar(title = "Create to do") {
                    onBackPressed()
            }) { paddingValues ->
                paddingValues.calculateBottomPadding()
                paddingValues.calculateTopPadding()
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val text = remember { mutableStateOf(TextFieldValue(viewModel.title)) }
                    TextField(
                        value = text.value,
                        label = titleLabel(text = "Title"),
                        placeholder = hintLabel(hint = "Input To Do Title"),
                        onValueChange = {
                            viewModel.title = it.text
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun titleLabel(text: String): @Composable () -> Unit = {
    Text(text = text)
}

@Composable
fun hintLabel(hint: String): @Composable () -> Unit = {
    Text(text = hint)
}