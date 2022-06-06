package com.tivoyudhap.maintodolist.cache

import android.content.Context
import androidx.room.Room
import com.tivoyudhap.maintodolist.support.KEY_TO_DO_DB

object CacheBuilder {

    fun getInstance(context: Context): ToDoDatabase {
        return Room.databaseBuilder(context, ToDoDatabase::class.java, KEY_TO_DO_DB).build()
    }
}