package com.example.tim.androidshowcase.REST

/**
 * Created by Tim on 12-7-2017.
 */

class Pokemon {

    var id: Int? = null
    var name: String? = null
    var height: Int? = null
    var weight: Int? = null

    override fun toString(): String {
        return String.format("This is %s, a pokemon with id '%d', weighing %dg with a height of %dcm.", name, id, weight!! * 100, height!! * 10)
    }
}
