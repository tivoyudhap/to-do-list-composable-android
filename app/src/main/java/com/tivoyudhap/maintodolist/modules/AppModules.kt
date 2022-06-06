package com.tivoyudhap.maintodolist.modules

import android.content.Context
import com.tivoyudhap.maintodolist.cache.CacheBuilder
import com.tivoyudhap.maintodolist.cache.ToDoDatabase
import com.tivoyudhap.maintodolist.repository.ToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModules {

    @Provides
    @Singleton
    fun getCacheBuilder(@ApplicationContext context: Context): ToDoDatabase = CacheBuilder.getInstance(context)

    @Provides
    fun getToDoRepository(database: ToDoDatabase): ToDoRepository = ToDoRepository(database)
}