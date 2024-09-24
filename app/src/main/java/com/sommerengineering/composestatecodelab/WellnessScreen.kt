package com.sommerengineering.composestatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        StatefulCounter()

        // .toMutableStateList() creates mutable, observable list from existing
        // mutableStateListOf identical result, both approaches create SnapshotStateList<T>

        // create list first, then pass to remember{}
        // do NOT: val list = remember { mutableStateListOf<WellnessTask>() }; list.addAll(getWellnessTasks())
        // instead, DO: val list = remember { mutableStateListOf<WellnessTask>().apply { addAll(getWellnessTasks()) }}
        // this avoids unnecessary observation of element additions

        // rememberSaveable will not work here because of mutable state list
        // alternate saving mechanism required

        val list = remember {
            getWellnessTasks().toMutableStateList()
        }

        WellnessTaskList(
            list = list,
            onCloseTask = { task -> list.remove(task) }
        )
    }
}