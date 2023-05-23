import androidx.lifecycle.Observer
import net.nponsard.test.Person

class Team : Observer<Person> {
    var persons = ArrayList<Person>()
    var chief = Person(
        "Guy", "Cathebras",
        "MEA3"
    )

    init {
        this.persons.add(Person("Christophe", "Fiorio", "MEA5"))
        this.persons.add(Person("Philippe", "Maurine", "MEA3"))
        this.persons.add(Person("Éric", "Dubreuil", "MEA4"))
        this.persons.add(chief)
    }

    override fun onChanged(t: Person?) {
        TODO("Not yet implemented")
    }

}