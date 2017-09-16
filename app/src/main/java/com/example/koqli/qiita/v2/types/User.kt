package com.example.koqli.qiita.v2.types

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class User(

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("linkedin_id")
	val linkedinId: String? = null,

	@field:SerializedName("profile_image_url")
	val profileImageUrl: String? = null,

	@field:SerializedName("permanent_id")
	val permanentId: Int? = null,

	@field:SerializedName("facebook_id")
	val facebookId: String? = null,

	@field:SerializedName("followees_count")
	val followeesCount: Int? = null,

	@field:SerializedName("items_count")
	val itemsCount: Int? = null,

	@field:SerializedName("twitter_screen_name")
	val twitterScreenName: String? = null,

	@field:SerializedName("website_url")
	val websiteUrl: String? = null,

	@field:SerializedName("followers_count")
	val followersCount: Int? = null,

	@field:SerializedName("organization")
	val organization: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("github_login_name")
	val githubLoginName: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)