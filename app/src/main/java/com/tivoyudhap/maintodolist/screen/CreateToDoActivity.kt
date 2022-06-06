package com.tivoyudhap.maintodolist.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
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
                Column {
                    TextField(
                        modifier = Modifier.padding(start = 8f.dp),
                        value = TextFieldValue(viewModel.title),
                        label = titleLabel(text = "Title"),
                        placeholder = hintLabel(hint = "asdasd"),
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