package com.example.koqli.domain.item

import com.example.koqli.domain.tagging.Tagging
import com.example.koqli.domain.tagging.TaggingConverter
import com.example.koqli.domain.user.User
import com.example.koqli.domain.user.UserConverter
import com.example.koqli.qiita.v2.types.Item as DataItem

/**
 * Created by biwaishi on 2017/09/16.
 */

object ItemConverter {
    fun toDomain(dataItem: DataItem): Item =
            Item(ItemIdentity(dataItem.id!!)).apply {
                itemInternal = ItemInternal(
                        renderedBody = dataItem.renderedBody,
                        jsonMemberPrivate = dataItem.jsonMemberPrivate,
                        createdAt = dataItem.createdAt,
                        body = dataItem.body,
                        title = dataItem.title,
                        url = dataItem.url,
                        tags = dataItem.tags?.let { TaggingConverter.toDomains(it) }?: listOf(),
                        likesCount = dataItem.likesCount,
                        updatedAt = dataItem.updatedAt,
                        commentsCount = dataItem.commentsCount,
                        reactionsCount = dataItem.reactionsCount,
                        coediting = dataItem.coediting,
                        user = dataItem.user?.let { UserConverter.toDomain(it) } ?:User.empty
                )
            }

    fun toDomains(dataItems: List<DataItem>): List<Item> =
            dataItems.map {
                toDomain(it)
            }

    fun toData(item: Item): DataItem{
        return DataItem(
                renderedBody = item.renderedBody,
                jsonMemberPrivate = item.jsonMemberPrivate,
                createdAt = item.createdAt,
                body = item.body,
                title = item.title,
                url = item.url,
                tags = TaggingConverter.toDataList(item.tags),
                likesCount = item.likesCount,
                updatedAt = item.updatedAt,
                commentsCount = item.commentsCount,
                reactionsCount = item.reactionsCount,
                coediting = item.coediting,
                user = UserConverter.toData(item.user!!),
                id = item.identity.value
        )
    }
}