package com.example.koqli.application

import com.example.koqli.domain.item.StockService
import com.example.koqli.usecase.AuthorizeAccount
import com.example.koqli.usecase.item.*
import com.example.koqli.usecase.tag.GetTagById
import com.example.koqli.usecase.tag.GetTags
import com.example.koqli.usecase.tag.GetTagsByUserId
import dagger.Component
import javax.inject.Singleton

/**
 * Created by biwaishi on 2017/09/10.
 */

@Singleton
@Component(modules = arrayOf(DomainModule::class, DataModule::class))
interface KoqliComponent{

    fun inject(application: Application)

    fun inject(authorizeAccount: AuthorizeAccount)

    fun inject(stockService: StockService)

    fun inject(getItems: GetItems)
    fun inject(getItemsByKeyword: GetItemsByKeyword)
    fun inject(getItemsByTagId: GetItemsByTagId)

    fun inject(getTags: GetTags)
    fun inject(getTagById: GetTagById)
    fun inject(getTagsByUserId: GetTagsByUserId)

    fun inject(isStockingItem: IsStockingItem)
    fun inject(stockItem: StockItem)
    fun inject(unstockItem: UnstockItem)
}