package com.example.koqli.domain.comment

import com.example.koqli.domain.user.User
import java.util.*

/**
 * Created by biwaishi on 2017/09/12.
 */

data class CommentInternal(
        val renderedBody: String?,
        val updatedAt: Date?,
        val createdAt: Date?,
        val id: String?,
        val body: String?,
        val user: User?
)