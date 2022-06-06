package com.tivoyudhap.maintodolist.cache.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.tivoyudhap.maintodolist.entity.data.ToDoDataEntity
import com.tivoyudhap.maintodolist.support.KEY_TO_DO

@Dao
interface ToDoDao {

    @Insert
    suspend fun insertToDo(entity: ToDoDataEntity)

    @Query("select * from $KEY_TO_DO")
    suspend fun getToDoList(): List<ToDoDataEntity?>

    @Delete
    suspend fun deleteToDo(entity: ToDoDataEntity)
}