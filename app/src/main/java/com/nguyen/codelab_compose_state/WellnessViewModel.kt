package com.nguyen.codelab_compose_state

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    // Define an internal _tasks variable, using toMutableStateList
    private val _tasks = getWellnessTasks().toMutableStateList()
    // expose tasks as a list, so it's not modifiable from outside the ViewModel
    val tasks: List<WellnessTask>
        get() = _tasks


    // delegate to the list's builtin remove function
    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    // receive a task to modify with a new value for the checked state
    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }