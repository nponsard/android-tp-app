package net.nponsard.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var persons = ArrayList<Person>()
    var selected: Person? = null
        get() = field
        set(value) {
            field = value
            editBarController.changeSelected(value)
        }

    var chief: Person = Person(
        "Guy", "Cathebras",
        "MEA3"
    )

    lateinit var listFragment: ListFragment
    lateinit var titleFragment: Title
    lateinit var editBarFragment: EditBarFragment
    lateinit var editBarController: EditBarController
    lateinit var listController: ListController
    lateinit var titleController: TitleController

    init {
        this.persons.add(Person("Christophe", "Fiorio", "MEA5"))
        this.persons.add(Person("Philippe", "Maurine", "MEA3"))
        this.persons.add(Person("Éric", "Dubreuil", "MEA4"))
        this.persons.add(chief)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentListView) as ListFragment
        titleFragment = supportFragmentManager.findFragmentById(R.id.fragmentTitleView) as Title
        editBarFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentEditView) as EditBarFragment

    }

    override fun onStart() {
        super.onStart()
        listController = ListController(listFragment, persons)
        titleController = TitleController(titleFragment, chief)
        editBarController = EditBarController(editBarFragment, selected, chief)
    }
}