package com.example.koqli.domain.tag

import com.example.koqli.qiita.v2.QiitaV2Api
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by biwaishi on 2017/09/16.
 */

class GetTags(private val qiitaV2Api: QiitaV2Api){

    fun getTags(page: Int, perPage: Int): Single<List<Tag>> =
            qiitaV2Api.getTags(page, perPage).map { TagConverter.toDomains(it) }

    fun getTagsByUserId(userId: String, page: Int, perPage: Int): Single<List<Tag>> =
            qiitaV2Api.getTagsByUserId(userId, page, perPage).map { TagConverter.toDomains(it) }

    fun getTagById(tagId: String): Single<Tag> =
            qiitaV2Api.getTagById(tagId).map { TagConverter.toDomain(it) }
}