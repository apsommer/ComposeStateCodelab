package com.sommerengineering.composestatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,

    // activity level viewmodel, exists outside the activity scope and will persist configuration changes
    wellnessViewModel: WellnessViewModel = viewModel()
) {
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

        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, isChecked -> wellnessViewModel.changeTaskChecked(task, isChecked) },
            onCloseTask = { task -> wellnessViewModel.remove(task) }
        )
    }
}