package com.example.koqli.domain.tagging

import java.io.Serializable

/**
 * Created by biwaishi on 2017/09/16.
 */
data class TaggingInternal(
        val versions: List<String?>? = null,
        val name: String? = null
) : Serializable