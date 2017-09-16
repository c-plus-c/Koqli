package com.example.koqli.domain.user

import com.google.gson.annotations.SerializedName

/**
 * Created by biwaishi on 2017/09/16.
 */
class User(val userIdentity: UserIdentity){

    companion object {
        val empty = User(UserIdentity("")).apply {
            userInternal = UserInternal()
        }
    }

    val description: String? get() = userInternal?.description
    val linkedinId: String? get() = userInternal?.linkedinId
    val profileImageUrl: String? get() = userInternal?.profileImageUrl
    val permanentId: Int?  get() = userInternal?.permanentId
    val facebookId: String?  get() = userInternal?.facebookId
    val followeesCount: Int? get() = userInternal?.followeesCount
    val itemsCount: Int?  get() = userInternal?.itemsCount
    val twitterScreenName: String? get() = userInternal?.twitterScreenName
    val websiteUrl: String?  get() = userInternal?.websiteUrl
    val followersCount: Int?  get() = userInternal?.followersCount
    val organization: String?  get() = userInternal?.organization
    val name: String? get() = userInternal?.name
    val location: String? get() = userInternal?.location
    val githubLoginName: String? get() = userInternal?.githubLoginName

    var userInternal:UserInternal? = null
}