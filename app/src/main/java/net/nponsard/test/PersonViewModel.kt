package net.nponsard.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


data class PersonState(
    val lastName: String,
    val editing: Boolean
)


class PersonViewModel(val firstName: String, lastName: String, val promo: String) : ViewModel() {

    var lastName: String = lastName
        set(value) {
            field = value
            _state.value = _state.value?.copy(lastName = value)
        }
        get() = _state.value?.lastName ?: ""
    var editing: Boolean = false
        set(value) {
            field = value
            _state.value = _state.value?.copy(editing = value)
        }
        get() = _state.value?.editing ?: false

    private val _state = MutableLiveData(PersonState(lastName, false))
    val state: LiveData<PersonState> = _state


    override fun toString(): String {
        return "$firstName $lastName" + if (editing) " (editing)" else ""
    }
}