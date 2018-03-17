package com.example.koqli.usecase.comment

import com.example.koqli.domain.comment.Comment
import com.example.koqli.domain.comment.CommentRepository
import com.example.koqli.usecase.BaseRxUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by biwaishi on 2018/03/04.
 */

class GetCommentsByItemId(private val itemId: String) : BaseRxUseCase<List<Comment>>() {

    @Inject
    lateinit var commentRepository: CommentRepository

    override fun source(): Single<List<Comment>> =
            commentRepository.getCommentsByItemId(itemId)

}