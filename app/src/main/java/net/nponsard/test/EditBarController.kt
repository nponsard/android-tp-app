package net.nponsard.test

import android.annotation.SuppressLint
import com.google.android.material.internal.ViewUtils
import java.util.Observable
import java.util.Observer

@SuppressLint("RestrictedApi")
class EditBarController(
    private val fragment: EditBarFragment,
    selected: Person?,
    var chief: Person
) : Observer {

    private var currentSelected: Person? = selected

    init {
        changeSelected(selected)

        // change the selected person when the user press enter
        fragment.editBar.setOnEditorActionListener { _, _, _ ->
            val text = fragment.editBar.text.toString()
            currentSelected?.lastName = text
            // hide the keyboard
            ViewUtils.hideKeyboard(fragment.editBar)
            true
        }
        fragment.button.setOnClickListener {
            chief.lastName = fragment.getString(R.string.default_chief_name)

        }

    }

    fun changeSelected(selected: Person?) {
        currentSelected?.deleteObserver(this)
        if (selected == null) {
            fragment.setVisibility(false)
            return
        }
        fragment.setVisibility(true)

        selected.addObserver(this)
        fragment.editBar.setText(selected.lastName)
        currentSelected = selected
    }

    @Deprecated("Deprecated in Java")
    override fun update(o: Observable?, arg: Any?) {
        fragment.editBar.setText((o as Person).lastName)
    }
}
