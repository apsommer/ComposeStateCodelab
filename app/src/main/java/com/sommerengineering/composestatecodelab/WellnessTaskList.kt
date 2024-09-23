package com.sommerengineering.composestatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

fun getWellnessTasks() = List(30) {
    i -> WellnessTask(i, "Task #$i")
}

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier
) {

    // use = operator here as custom function above does not include getter/setter for delegation
    val list = remember { getWellnessTasks() }

    LazyColumn(
        modifier = modifier) {
        items(list) { task ->
            WellnessTaskItem(task.label)
        }
    }
}
