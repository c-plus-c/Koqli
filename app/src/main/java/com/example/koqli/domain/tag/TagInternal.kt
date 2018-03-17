package com.example.koqli.domain.tag

import java.io.Serializable

/**
 * Created by biwaishi on 2017/09/16.
 */
data class TagInternal(
        val iconUrl: String?,
        val itemsCount: Int?,
        val followersCount: Int?
) : Serializable