package com.sommerengineering.composestatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier) {
        items(
            items = list,
            // data class = list item key for mutable lists!
            key = { task -> task.id }) { task ->
            WellnessTaskItem(
                taskName = task.label,
                isChecked = task.isChecked,
                onCheckedChange = { isChecked -> onCheckedTask(task, isChecked) },
                onClose = { onCloseTask(task) })
        }
    }
}
