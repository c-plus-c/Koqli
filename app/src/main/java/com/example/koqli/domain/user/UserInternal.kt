package com.example.koqli.domain.user

import java.io.Serializable

/**
 * Created by biwaishi on 2017/09/16.
 */

data class UserInternal(
        val description: String? = null,
        val linkedinId: String? = null,
        val profileImageUrl: String? = null,
        val permanentId: Int? = null,
        val facebookId: String? = null,
        val followeesCount: Int? = null,
        val itemsCount: Int? = null,
        val twitterScreenName: String? = null,
        val websiteUrl: String? = null,
        val followersCount: Int? = null,
        val organization: String? = null,
        val name: String? = null,
        val location: String? = null,
        val githubLoginName: String? = null
) : Serializable