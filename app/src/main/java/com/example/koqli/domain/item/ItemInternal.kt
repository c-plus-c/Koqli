package com.example.koqli.domain.item

import com.example.koqli.domain.tagging.Tagging
import com.example.koqli.domain.user.User
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by biwaishi on 2017/09/16.
 */
data class ItemInternal(
        val renderedBody: String? = null,
        val jsonMemberPrivate: Boolean? = null,
        val createdAt: Date? = null,
        val body: String? = null,
        val title: String? = null,
        val url: String? = null,
        val tags: List<Tagging?>? = null,
        val likesCount: Int? = null,
        val updatedAt: Date? = null,
        val commentsCount: Int? = null,
        val reactionsCount: Int? = null,
        val id: String? = null,
        val coediting: Boolean? = null,
        val user: User? = null
)