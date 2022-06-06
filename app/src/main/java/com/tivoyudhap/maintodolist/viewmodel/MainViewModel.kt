package com.tivoyudhap.maintodolist.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tivoyudhap.maintodolist.entity.data.ToDoDataEntity
import com.tivoyudhap.maintodolist.entity.mapper.ToDoMapper
import com.tivoyudhap.maintodolist.entity.ui.LiveDataEntity
import com.tivoyudhap.maintodolist.entity.ui.State
import com.tivoyudhap.maintodolist.entity.ui.ToDoUIEntity
import com.tivoyudhap.maintodolist.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ToDoRepository
): ViewModel() {

    val toDoState = mutableStateListOf<ToDoUIEntity>()

    fun insertSomeData() {
        viewModelScope.launch {
            repository.insertToDo(ToDoDataEntity(
                title = "Percobaan 1",
                description = "Hahaha",
                dueDate = Date().time + (1000 * 1000 * 360 * 3),
                createdAt = Date().time
            ))

            loadToDoList()
        }
    }

    fun loadToDoList() {
        viewModelScope.launch {
            toDoState.clear()
            toDoState.addAll(
                repository.getToDo()
                    .map { entity ->
                        entity?.let { nonNull ->
                            return@map ToDoMapper.map(nonNull)
                        }
                        ToDoUIEntity()
                }
            )
        }

    }
}