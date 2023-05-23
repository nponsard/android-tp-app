package net.nponsard.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

/**
 * A simple [Fragment] subclass.
 * Use the [EditBarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditBarFragment : Fragment() {
    lateinit var editBar: EditText
    lateinit var button: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edit_bar, container, false)

        editBar = view.findViewById(R.id.editText)
        button = view.findViewById(R.id.button)
        setVisibility(false)
        return view
    }

    fun setVisibility(visible: Boolean) {
        if (visible) {
            view?.visibility = View.VISIBLE
        } else {
            view?.visibility = View.INVISIBLE
        }
    }
}