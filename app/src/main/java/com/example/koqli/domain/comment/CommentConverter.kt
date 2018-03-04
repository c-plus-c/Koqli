package com.example.koqli.domain.comment

import com.example.koqli.domain.user.User
import com.example.koqli.domain.user.UserConverter
import com.example.koqli.domain.user.UserIdentity
import com.example.koqli.qiita.v2.types.Comment as DataComment

/**
 * Created by biwaishi on 2017/09/12.
 */
object CommentConverter{
    fun toDomain(dataComment: DataComment): Comment = Comment(CommentIdentity(dataComment.id!!)).apply{
        internal = CommentInternal(
                renderedBody = dataComment.renderedBody,
                updatedAt = dataComment.updatedAt,
                createdAt = dataComment.createdAt,
                user = dataComment.user?.let { UserConverter.toDomain(it)}?:User.empty,
                id = dataComment.id,
                body = dataComment.body)
    }

    fun toDomains(dataComment: Collection<DataComment>): List<Comment> = dataComment.map { toDomain(it) }
}