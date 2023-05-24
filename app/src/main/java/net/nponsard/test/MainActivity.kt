package net.nponsard.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData

class MainActivity : AppCompatActivity() {
    var persons = ArrayList<PersonViewModel>()
    var selected: MutableLiveData<PersonViewModel?> = MutableLiveData(null)

    lateinit var chief: PersonViewModel

    lateinit var listFragment: ListFragment
    lateinit var titleFragment: TitleFragment
    lateinit var editBarFragment: EditBarFragment
    lateinit var editBarController: EditBarController
    lateinit var listController: ListController
    lateinit var titleController: TitleController

    init {
        this.persons.add(PersonViewModel("Christophe", "Fiorio", "MEA5"))
        this.persons.add(PersonViewModel("Philippe", "Maurine", "MEA3"))
        this.persons.add(PersonViewModel("Éric", "Dubreuil", "MEA4"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chief = PersonViewModel(
            "Guy", getString(R.string.default_chief_name),
            "MEA3"
        )
        this.persons.add(chief)


        listFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentListView) as ListFragment
        titleFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentTitleView) as TitleFragment
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