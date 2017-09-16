package com.example.koqli.domain.tagging

import com.google.gson.annotations.SerializedName

/**
 * Created by biwaishi on 2017/09/16.
 */
data class TaggingInternal(
        val versions: List<String?>? = null,
        val name: String? = null
)