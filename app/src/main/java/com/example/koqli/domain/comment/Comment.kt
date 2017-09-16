package com.example.koqli.domain.comment

import com.example.koqli.domain.AbstractEntity
import com.example.koqli.domain.user.User
import java.util.*

/**
 * Created by biwaishi on 2017/09/12.
 */

class Comment(commentIdentity: CommentIdentity): AbstractEntity<CommentIdentity, Comment>(commentIdentity){

    companion object {
        val empty: Comment = Comment(CommentIdentity("")).apply {
            internal = CommentInternal("",null,null,null,null,null)
        }
    }

    val renderedBody: String? get() = internal?.renderedBody
    val updatedAt: Date? get() = internal?.updatedAt
    val createdAt: Date? get() = internal?.createdAt
    val body get() : String? = internal?.body
    val user: User? get() = internal?.user

    var internal: CommentInternal? = null
}