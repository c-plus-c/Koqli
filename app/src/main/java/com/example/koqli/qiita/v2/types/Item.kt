package com.example.koqli.qiita.v2.types

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.util.*

@Generated("com.robohorse.robopojogenerator")
data class Item(

        @field:SerializedName("rendered_body")
	val renderedBody: String? = null,

        @field:SerializedName("private")
	val jsonMemberPrivate: Boolean? = null,

        @field:SerializedName("created_at")
	val createdAt: Date? = null,

        @field:SerializedName("body")
	val body: String? = null,

        @field:SerializedName("title")
	val title: String? = null,

        @field:SerializedName("url")
	val url: String? = null,

        @field:SerializedName("tags")
	val tags: List<Tagging?>? = null,

        @field:SerializedName("likes_count")
	val likesCount: Int? = null,

        @field:SerializedName("updated_at")
	val updatedAt: Date? = null,

        @field:SerializedName("comments_count")
	val commentsCount: Int? = null,

        @field:SerializedName("reactions_count")
	val reactionsCount: Int? = null,

        @field:SerializedName("id")
	val id: String? = null,

        @field:SerializedName("coediting")
	val coediting: Boolean? = null,

        @field:SerializedName("user")
	val user: User? = null
)