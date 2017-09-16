package com.example.koqli.domain

import java.io.Serializable

/**
 * Created by biwaishi on 2017/09/12.
 */

interface Entity<I: Identity<*>, E: Entity<I,E>> : Cloneable, Serializable{

    val identity: I

    fun isSame(entity: Entity<I,E>): Boolean

    fun equals(other: E): Boolean

    override fun clone(): E
}