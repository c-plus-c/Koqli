package com.example.koqli.domain.tag

import com.example.koqli.qiita.v2.types.Tag as DataTag
/**
 * Created by biwaishi on 2017/09/16.
 */

object TagConverter{
    fun toDomain(dataTag: DataTag):Tag =
            Tag(TagIdentity(dataTag.id!!)).apply {
                tagInternal = TagInternal(
                        iconUrl = dataTag.iconUrl,
                        itemsCount = dataTag.itemsCount,
                        followersCount =  dataTag.followersCount
                )
            }

    fun toDomains(dataTags: List<DataTag>):List<Tag> =
            dataTags.map {
                toDomain(it)
            }

    fun toData(tag: Tag): DataTag =
            DataTag(
                    iconUrl = tag.iconUrl,
                    itemsCount =  tag.itemsCount,
                    followersCount =  tag.followersCount,
                    id = tag.identity.value
            )
}