package net.nponsard.test

import android.widget.ArrayAdapter

class ListController(private val view: ListFragment, private val list: ArrayList<PersonViewModel>) {

    var context: MainActivity = view.activity as MainActivity

    init {

        for (person in list) {
            person.state.observe(context) {
                update()
            }
        }

        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, list)
        val listView = view.listView

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, _, position, _ ->
            parent.getItemAtPosition(position) as PersonViewModel
            context.selected.value?.editing = false
            context.selected.value = list[position]
            context.selected.value?.editing = true
        }

    }

    private fun update() {
        (view.listView.adapter as ArrayAdapter<*>).notifyDataSetChanged()
    }


}