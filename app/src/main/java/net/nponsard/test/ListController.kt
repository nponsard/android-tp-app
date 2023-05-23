package net.nponsard.test

import android.widget.ArrayAdapter
import java.util.ArrayList
import java.util.Observable
import java.util.Observer

class ListController(private val view:ListFragment, private val list: ArrayList<Person>) : Observer {

    var context : MainActivity = view.activity as MainActivity

    init {

        for (person in list) {
            person.addObserver(this)
        }


        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, list)
        val listView = view.listView

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, _, position, _ ->
            val person = parent.getItemAtPosition(position) as Person
            context.selected = list[position]
        }

    }

    @Deprecated("Deprecated in Java")
    override fun update(o: Observable?, arg: Any?) {
        (view.listView.adapter as ArrayAdapter<*>).notifyDataSetChanged()
    }


}