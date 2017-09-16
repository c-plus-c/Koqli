package com.example.koqli.domain

import org.apache.commons.lang3.SerializationUtils

/**
 * Created by biwaishi on 2017/09/12.
 */

abstract class AbstractEntity<I: Identity<*>, E: Entity<I, E>>(override val identity: I): Entity<I, E>{
    override fun isSame(entity: Entity<I, E>): Boolean = entity.identity == identity

    override fun equals(other: E): Boolean = this == other || (this is Entity<I,E> && isSame(other))

    override fun clone(): E = SerializationUtils.clone(this) as E
}