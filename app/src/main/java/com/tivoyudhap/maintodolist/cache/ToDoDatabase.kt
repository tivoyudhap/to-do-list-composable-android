package com.tivoyudhap.maintodolist.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tivoyudhap.maintodolist.cache.dao.ToDoDao
import com.tivoyudhap.maintodolist.entity.data.ToDoDataEntity

@Database(entities = [ToDoDataEntity::class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}