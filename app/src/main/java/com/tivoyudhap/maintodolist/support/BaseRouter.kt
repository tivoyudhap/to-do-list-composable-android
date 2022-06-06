package com.tivoyudhap.maintodolist.support

import android.content.Context
import android.content.Intent
import com.tivoyudhap.maintodolist.screen.CreateToDoActivity

object BaseRouter {
    fun createToDoActivity(context: Context): Intent =
        Intent(context, CreateToDoActivity::class.java)
}