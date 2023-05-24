package net.nponsard.test

class Person(var firstName: String, val lastName: String, var promo: String) {

    override fun toString(): String {
        return "$firstName $lastName"
    }

}