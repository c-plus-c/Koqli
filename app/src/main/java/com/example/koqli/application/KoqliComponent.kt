package com.example.koqli.application

import com.example.koqli.domain.item.GetItems
import com.example.koqli.domain.item.StockService
import com.example.koqli.domain.tag.GetTags
import com.example.koqli.usecase.AuthorizeAccount
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

    fun inject(getTags: GetTags)
}