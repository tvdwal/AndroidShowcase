package com.example.tim.androidshowcase.Realm

import java.io.Serializable

class Person : Serializable {
    var name: String
    var age: Int
    var profession: String
    var important: Boolean

    constructor(name: String, age: Int, profession: String) {
        this.name = name
        this.age = age
        this.profession = profession
        important = false
    }

    fun setImportance(importance: Boolean) {
        important = importance
    }
}
