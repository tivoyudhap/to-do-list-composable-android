package com.tivoyudhap.maintodolist.entity.ui

data class ToDoUIEntity (
    var id: Int = 0,
    var title: String = "",
    var description: String = "",
    var dueDate: Long = 0,
    var createdAt: Long = 0
)