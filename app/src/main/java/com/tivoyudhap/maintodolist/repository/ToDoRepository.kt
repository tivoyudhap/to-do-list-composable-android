package com.tivoyudhap.maintodolist.repository

import com.tivoyudhap.maintodolist.cache.ToDoDatabase
import com.tivoyudhap.maintodolist.entity.data.ToDoDataEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    private var database: ToDoDatabase
) {

    suspend fun insertToDo(entity: ToDoDataEntity) {
        database.toDoDao().insertToDo(entity)
    }

    suspend fun getToDo(): List<ToDoDataEntity?> = database.toDoDao().getToDoList()

    suspend fun deleteToDo(entity: ToDoDataEntity) {
        database.toDoDao().deleteToDo(entity)
    }
}