package com.example.koqli.usecase.tag

import com.example.koqli.domain.tag.Tag
import com.example.koqli.domain.tag.TagRepository
import com.example.koqli.usecase.BaseRxUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by biwaishi on 2017/09/16.
 */

class GetTagById(private val tagId: String): BaseRxUseCase<Tag>(){

    @Inject
    lateinit var tagRepository: TagRepository

    override fun source(): Single<Tag> =
            tagRepository.getTagById(tagId)
}