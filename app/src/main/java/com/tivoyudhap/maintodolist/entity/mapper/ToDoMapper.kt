package com.tivoyudhap.maintodolist.entity.mapper

import com.tivoyudhap.maintodolist.entity.data.ToDoDataEntity
import com.tivoyudhap.maintodolist.entity.ui.ToDoUIEntity

object ToDoMapper {
    fun map(entity: ToDoDataEntity): ToDoUIEntity = ToDoUIEntity(
        id = entity.id,
        title = entity.title,
        description = entity.description,
        dueDate = entity.dueDate,
        createdAt = entity.createdAt
    )
}