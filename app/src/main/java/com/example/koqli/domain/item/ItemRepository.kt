package com.example.koqli.domain.item

import com.example.koqli.domain.tag.TagIdentity
import com.example.koqli.qiita.v2.QiitaV2Api
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

/**
 * Created by biwaishi on 2017/09/16.
 */

class ItemRepository(private val qiitaV2Api: QiitaV2Api){

    fun getItems(page: Int, perPage: Int): Single<List<Item>> =
            qiitaV2Api.getItems(page, perPage).map{ItemConverter.toDomains(it)}

    fun getItemsByKeyword(query: String, page: Int, perPage: Int): Single<List<Item>> =
            qiitaV2Api.getItemsByKeyword(query, page, perPage).map{ItemConverter.toDomains(it)}

    fun getItemsByTagId(tagId: String, page: Int, perPage: Int): Single<List<Item>> =
            qiitaV2Api.getItemsByTagId(tagId, page, perPage).map{ItemConverter.toDomains(it)}

    fun getStockedItems(userId: String, page: Int, perPage: Int): Single<List<Item>> =
            qiitaV2Api.getStockedItems(userId, page, perPage).map { ItemConverter.toDomains(it) }

    fun getAuthenticatedUsersItems(page: Int, perPage: Int): Single<List<Item>> =
            qiitaV2Api.getAuthenticatedUsersItems(page, perPage).map { ItemConverter.toDomains(it) }

    fun getItemsByUserId(userId: String, page: Int, perPage: Int): Single<List<Item>> =
            qiitaV2Api.getItemsByUserId(userId, page, perPage).map { ItemConverter.toDomains(it) }

    fun getTagFeedItems(tagIdentities: List<TagIdentity>, page: Int, perPage: Int): Single<List<Item>> =
            qiitaV2Api.getItemsByKeyword(tagIdentities.joinToString(separator = " OR ", transform = {"tag:${it.value}"}), page, perPage).map { ItemConverter.toDomains(it) }
}