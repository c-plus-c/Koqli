package com.example.koqli.usecase.tag

import com.example.koqli.domain.tag.GetTags
import com.example.koqli.domain.tag.Tag
import com.example.koqli.usecase.BaseRxUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by biwaishi on 2017/09/16.
 */

class GetTags(private val page: Int, private val perPage: Int): BaseRxUseCase<List<Tag>>() {

    @Inject
    lateinit var getTagDomain: GetTags

    override fun source(): Single<List<Tag>> {
        return getTagDomain.getTags(page, perPage)
    }

}