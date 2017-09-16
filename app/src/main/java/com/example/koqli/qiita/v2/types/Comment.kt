package com.example.koqli.qiita.v2.types

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.util.*

@Generated("com.robohorse.robopojogenerator")
data class Comment(

	@field:SerializedName("rendered_body")
	val renderedBody: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Date? = null,

	@field:SerializedName("created_at")
	val createdAt: Date? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("user")
	val user: User? = null
)