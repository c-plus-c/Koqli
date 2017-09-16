package com.example.koqli.domain.tag

import com.example.koqli.domain.AbstractEntity

/**
 * Created by biwaishi on 2017/09/16.
 */

class Tag(tagIdentity: TagIdentity): AbstractEntity<TagIdentity, Tag>(tagIdentity){
    companion object {
        val empty = Tag(TagIdentity("")).apply {
            tagInternal = TagInternal(null,null,null)
        }
    }

    val iconUrl: String? get() = tagInternal?.iconUrl
    val itemsCount: Int? get() = tagInternal?.itemsCount
    val followersCount: Int? get() = tagInternal?.followersCount

    var tagInternal: TagInternal? = null
}