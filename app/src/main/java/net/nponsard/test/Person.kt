package net.nponsard.test

import java.util.Observable


public class Person (var firstName: String, lastName: String, var promo: String) : Observable(){
    var lastName = lastName
        get() = field
        set(value) {
            field = value
            setChanged()
            notifyObservers()
        }

    override fun toString(): String {
        return "$firstName $lastName"
    }

}