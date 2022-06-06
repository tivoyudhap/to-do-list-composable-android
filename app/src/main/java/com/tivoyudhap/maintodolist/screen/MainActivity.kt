package com.tivoyudhap.maintodolist.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.lifecycle.ViewModelProvider
import com.tivoyudhap.maintodolist.support.BaseRouter
import com.tivoyudhap.maintodolist.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    private val viewModel: MainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    private val toDoResultContract: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { activityResult ->
        activityResult.data?.let {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadToDoList()
        setContent {
            Scaffold(
                floatingActionButton = floatingActionButton {
                    goToCreateToDo()
                },
                floatingActionButtonPosition = FabPosition.End,
                content = {
                    ToDoList(
                        viewModel = viewModel,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    )

                    it.calculateBottomPadding()
                }
            )
        }
    }

    private fun goToCreateToDo() {
        toDoResultContract.launch(BaseRouter.createToDoActivity(this))
    }
}

@Composable
fun floatingActionButton(onClick: () -> Unit): @Composable () -> Unit {
    return {
        FloatingActionButton(
            onClick = onClick
        ) {
            Icon(Icons.Filled.Add, "")
        }
    }
}

@Composable
fun ToDoList(viewModel: MainViewModel, modifier: Modifier) {
    LazyColumn(modifier = modifier, contentPadding = PaddingValues(start = Dp(16f), end = Dp(16f), top = Dp(4f), bottom = Dp(4f))) {
        items(items = viewModel.toDoState) { item ->
            ToDoListItem(label = item.title)
        }
    }
}

@Composable
fun ToDoListItem(label: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dp(8f)),
        elevation = 12f.dp,
        shape = RoundedCornerShape(8f.dp)
    ) {
        Column(modifier = Modifier.padding(start = Dp(16f), end = Dp(16f), top = Dp(4f), bottom = Dp(4f))) {
            Text(text = label, modifier = Modifier, fontWeight = FontWeight.Bold, fontSize = 15f.sp)
            Row{
                Text(text = "asdasdasd", fontSize = 13f.sp, modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 8f.dp, bottom = 8f.dp))
                Text(text = "wkwkwkw", fontSize = 13f.sp, modifier = Modifier.padding(top = 8f.dp))
            }
        }
    }
}