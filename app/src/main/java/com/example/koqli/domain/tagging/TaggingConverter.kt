package com.example.koqli.domain.tagging

import com.example.koqli.domain.tag.TagIdentity
import com.example.koqli.domain.tag.TagInternal
import com.example.koqli.qiita.v2.types.Tag
import com.example.koqli.qiita.v2.types.Tagging as DataTagging

/**
 * Created by biwaishi on 2017/09/16.
 */

object TaggingConverter{
    fun toDomain(dataTagging: DataTagging?):Tagging =
            Tagging(TaggingIdentity(dataTagging?.name!!)).apply {
                taggingInternal = TaggingInternal(dataTagging.versions, dataTagging.name)
            }


    fun toDomains(dataTaggings: List<DataTagging?>):List<Tagging?> =
            dataTaggings.map {
                toDomain(it)
            }

    fun toData(tagging: Tagging?): DataTagging =
            DataTagging(
                    versions = tagging?.versions,
                    name = tagging?.name
            )

    fun toDataList(tags: List<Tagging?>?): List<DataTagging?>? {
        return tags?.map {
            toData(it)
        }
    }
}