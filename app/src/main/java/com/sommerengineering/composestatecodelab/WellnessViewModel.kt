package com.sommerengineering.composestatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

// example data
fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task #$i") }

class WellnessViewModel : ViewModel() {

    // private state, exposed as read-only
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    
    fun remove(item: WellnessTask) { _tasks.remove(item) }
}