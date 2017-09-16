package com.example.koqli.domain.tagging

import com.example.koqli.domain.AbstractEntity
import com.example.koqli.domain.Identity
import com.example.koqli.domain.tag.Tag
import com.example.koqli.domain.tag.TagIdentity
import com.example.koqli.domain.tag.TagInternal

/**
 * Created by biwaishi on 2017/09/16.
 */
class Tagging(taggingIdentity: TaggingIdentity): AbstractEntity<TaggingIdentity, Tagging>(taggingIdentity){
    companion object {
        val empty = Tagging(TaggingIdentity("")).apply {
            taggingInternal = TaggingInternal(null,null)
        }
    }
    val versions: List<String?>?get() = taggingInternal?.versions
    val name: String? get() = taggingInternal?.name

    var taggingInternal: TaggingInternal? = null
}