package net.nponsard.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    var persons = ArrayList<Person>()
    var selected: Person? = null
    var chief: Person = Person(
        "Guy", "Cathebras",
        "MEA3"
    )

    init {
        this.persons.add(Person("Christophe", "Fiorio", "MEA5"))
        this.persons.add(Person("Philippe", "Maurine", "MEA3"))
        this.persons.add(Person("Éric", "Dubreuil", "MEA4"))
        this.persons.add(chief)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}