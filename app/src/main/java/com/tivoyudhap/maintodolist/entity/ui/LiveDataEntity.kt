package com.tivoyudhap.maintodolist.entity.ui

enum class State {
    STATE_LOADING,
    STATE_SUCCESS,
    STATE_FAILED,
    STATE_DONE_LOADING
}

data class LiveDataEntity<T>(
    var state: State,
    var message: String = "",
    var data: T? = null
)
