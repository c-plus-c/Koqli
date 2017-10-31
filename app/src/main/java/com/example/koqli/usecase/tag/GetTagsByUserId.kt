package com.example.koqli.usecase.tag

import com.example.koqli.domain.tag.Tag
import com.example.koqli.domain.tag.TagRepository
import com.example.koqli.usecase.BaseRxUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by biwaishi on 2017/09/16.
 */
class GetTagsByUserId(private val userId: String, private val page: Int, private val perPage: Int):BaseRxUseCase<List<Tag>>(){

    @Inject
    lateinit var tagRepository: TagRepository

    override fun source(): Single<List<Tag>> =
            tagRepository.getTagsByUserId(userId, page, perPage)
}