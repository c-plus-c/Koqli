package com.example.koqli.domain

import java.io.Serializable

/**
 * Created by biwaishi on 2017/09/12.
 */
interface Identity<V>: Serializable{
    val value: V
}