package net.nponsard.test

import java.util.Observer

class TitleController(private val fragment: Title, chief: Person) : Observer {

    init {
        chief.addObserver(this)
        fragment.title.text = chief.toString()
    }

    @Deprecated("Deprecated in Java")
    override fun update(o: java.util.Observable?, arg: Any?) {
        fragment.title.text = o.toString()
    }
}