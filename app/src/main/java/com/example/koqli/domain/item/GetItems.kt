package com.example.koqli.domain.item

import com.example.koqli.qiita.v2.QiitaV2Api
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

/**
 * Created by biwaishi on 2017/09/16.
 */

class GetItems(private val qiitaV2Api: QiitaV2Api){

    fun getItems(page: Int, perPage: Int): Single<List<Item>> =
            qiitaV2Api.getItems(page, perPage).map{ItemConverter.toDomains(it)}

    fun getItemsByKeyword(query: String, page: Int, perPage: Int): Single<List<Item>> =
            qiitaV2Api.getItemsByKeyword(query, page, perPage).map{ItemConverter.toDomains(it)}

    fun getItemsByTagId(tagId: String, page: Int, perPage: Int): Single<List<Item>> =
            qiitaV2Api.getItemsByTagId(tagId, page, perPage).map{ItemConverter.toDomains(it)}
}