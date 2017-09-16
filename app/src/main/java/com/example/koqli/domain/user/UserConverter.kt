package com.example.koqli.domain.user

import com.example.koqli.qiita.v2.types.User as DataUser

/**
 * Created by biwaishi on 2017/09/16.
 */

object UserConverter {
    fun toDomain(dataUser: DataUser): User = User(UserIdentity(dataUser.id!!)).apply {
        userInternal = UserInternal(
                description = dataUser.description,
                linkedinId = dataUser.linkedinId,
                profileImageUrl = dataUser.profileImageUrl,
                permanentId = dataUser.permanentId,
                facebookId = dataUser.facebookId,
                followeesCount = dataUser.followeesCount,
                itemsCount = dataUser.itemsCount,
                twitterScreenName = dataUser.twitterScreenName,
                websiteUrl = dataUser.websiteUrl,
                followersCount = dataUser.followersCount,
                organization = dataUser.organization,
                name = dataUser.name,
                location = dataUser.location,
                githubLoginName = dataUser.githubLoginName
        )
    }

    fun toData(user: User): DataUser =
            DataUser(
                    description = user.description,
                    linkedinId = user.linkedinId,
                    profileImageUrl = user.profileImageUrl,
                    permanentId = user.permanentId,
                    facebookId = user.facebookId,
                    followeesCount = user.followeesCount,
                    itemsCount = user.itemsCount,
                    twitterScreenName = user.twitterScreenName,
                    websiteUrl = user.websiteUrl,
                    followersCount = user.followersCount,
                    organization = user.organization,
                    name = user.name,
                    location = user.location,
                    githubLoginName = user.githubLoginName,
                    id = user.userIdentity.value
            )
}