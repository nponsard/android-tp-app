package net.nponsard.test

import java.util.ArrayList
import java.util.Observable
import java.util.Observer

class ListController(view:ListFragment, list: ArrayList<Person>) : Observer {

    lateinit var context : MainActivity

    init {
    }

    override fun update(o: Observable?, arg: Any?) {
        TODO("Not yet implemented")
    }


}