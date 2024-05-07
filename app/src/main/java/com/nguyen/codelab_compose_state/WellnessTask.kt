package com.nguyen.codelab_compose_state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

// data class WellnessTask(val id: Int, val label: String, val checked: MutableState<Boolean> = mutableStateOf(false))
// but you can use delegated properties, which results in a simpler usage of the variable checked

// Change WellnessTask to be a class instead of a data class. Make WellnessTask receive an
// initialChecked variable with default value false in the constructor, then we can initialize the
// checked variable with the factory method mutableStateOf and taking initialChecked as default value
class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {
    var checked by mutableStateOf(initialChecked)
}