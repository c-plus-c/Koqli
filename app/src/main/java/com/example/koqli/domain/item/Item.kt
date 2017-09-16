package com.example.koqli.domain.item

import com.example.koqli.domain.AbstractEntity
import com.example.koqli.domain.tagging.Tagging
import com.example.koqli.domain.tagging.TaggingConverter
import com.example.koqli.domain.user.User
import com.example.koqli.domain.user.UserConverter
import java.util.*

/**
 * Created by biwaishi on 2017/09/16.
 */
class Item(itemIdentity: ItemIdentity): AbstractEntity<ItemIdentity, Item>(itemIdentity){
    companion object {
        val empty = Item(ItemIdentity("")).apply {
            itemInternal = ItemInternal(null,null,null,null,null,null,null,null,null,null,null,null,null,null)
        }
    }
    val renderedBody: String? get() = itemInternal?.renderedBody
    val jsonMemberPrivate: Boolean? get() = itemInternal?.jsonMemberPrivate
    val createdAt: Date? get() = itemInternal?.createdAt
    val body: String? get() = itemInternal?.body
    val title: String? get() = itemInternal?.title
    val url: String? get() = itemInternal?.url
    val tags: List<Tagging?>? get() = itemInternal?.tags
    val likesCount: Int? get() = itemInternal?.likesCount
    val updatedAt: Date? get() = itemInternal?.updatedAt
    val commentsCount: Int? get() = itemInternal?.commentsCount
    val reactionsCount: Int? get() = itemInternal?.reactionsCount
    val coediting: Boolean? get() = itemInternal?.coediting
    val user: User? get() = itemInternal?.user

    var itemInternal: ItemInternal? = null
}