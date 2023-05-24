package net.nponsard.test

class TitleController(private val fragment: TitleFragment, private val chief: PersonViewModel) {

    init {
        chief.state.observe(fragment) {
            update()
        }
        update()
    }

    private fun update() {
        fragment.title.text = chief.toString()
    }

}