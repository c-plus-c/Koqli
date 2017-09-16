package com.example.koqli.qiita.v2.types

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Tag(

	@field:SerializedName("icon_url")
	val iconUrl: String? = null,

	@field:SerializedName("items_count")
	val itemsCount: Int? = null,

	@field:SerializedName("followers_count")
	val followersCount: Int? = null,

	@field:SerializedName("id")
	val id: String? = null
)