package net.nponsard.test

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.google.android.material.internal.ViewUtils

@SuppressLint("RestrictedApi")
class EditBarController(
    private val fragment: EditBarFragment,
    selected: MutableLiveData<PersonViewModel?>,
    var chief: PersonViewModel
) {

    private var observer = { _: PersonState? ->
        fragment.editBar.setText(currentSelected?.lastName)
    }
    private var currentSelected = selected.value

    init {
        changeSelected(selected.value)

        // change the selected person when the user press enter
        fragment.editBar.setOnEditorActionListener { _, _, _ ->
            val text = fragment.editBar.text.toString()
            currentSelected?.lastName = text
            currentSelected?.editing = false
            // hide the keyboard
            ViewUtils.hideKeyboard(fragment.editBar)
            true
        }
        fragment.button.setOnClickListener {
            chief.lastName = fragment.getString(R.string.default_chief_name)
        }

        selected.observe(fragment) {
            changeSelected(it)
        }

    }

    private fun changeSelected(selected: PersonViewModel?) {

        currentSelected?.state?.removeObserver(observer)

        if (selected == null) {
            fragment.setVisibility(false)
            return
        }
        fragment.setVisibility(true)

        currentSelected = selected
        currentSelected?.state?.observe(fragment, observer)
        update()
    }

    private fun update() {
        fragment.editBar.setText(currentSelected?.lastName)
    }
}
