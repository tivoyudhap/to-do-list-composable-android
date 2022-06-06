package com.tivoyudhap.maintodolist.entity.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tivoyudhap.maintodolist.support.*

@Entity(tableName = KEY_TO_DO)
data class ToDoDataEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = KEY_ID) var id: Int = 0,
    @ColumnInfo(name = KEY_TITLE) var title: String = "",
    @ColumnInfo(name = KEY_DESCRIPTION) var description: String = "",
    @ColumnInfo(name = KEY_DUE_DATE) var dueDate: Long = 0,
    @ColumnInfo(name = KEY_CREATED_AT) var createdAt: Long = 0
)
