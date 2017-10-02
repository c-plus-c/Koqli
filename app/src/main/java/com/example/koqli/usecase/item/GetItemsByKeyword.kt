package com.example.koqli.usecase.item

import com.example.koqli.domain.item.GetItems
import com.example.koqli.domain.item.Item
import com.example.koqli.usecase.BaseRxUseCase
import io.reactivex.Single
import javax.inject.Inject
import javax.xml.transform.Source

/**
 * Created by biwaishi on 2017/10/02.
 */

class GetItemsByKeyword (private val query: String, private val page: Int, private val perPage: Int): BaseRxUseCase<MutableList<Item>>(){

    @Inject
    lateinit var getItems: GetItems

    override fun source(): Single<MutableList<Item>> =
            Single.create {
                getItems.getItemsByKeyword(query, page, perPage)
            }
}