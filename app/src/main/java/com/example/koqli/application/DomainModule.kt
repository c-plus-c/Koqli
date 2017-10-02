package com.example.koqli.application

import android.content.Context
import com.example.koqli.domain.item.GetItems
import com.example.koqli.domain.item.StockService
import com.example.koqli.domain.tag.GetTags
import com.example.koqli.qiita.v2.QiitaV2Api
import com.example.koqli.usecase.item.GetItemsByKeyword
import com.securepreferences.SecurePreferences
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by biwaishi on 2017/09/10.
 */

@Module
class DomainModule{

    @Provides
    fun provideGetItems(qiitaV2Api:QiitaV2Api) = GetItems(qiitaV2Api)

    @Provides
    fun provideGetTags(qiitaV2Api:QiitaV2Api) = GetTags(qiitaV2Api)

    @Provides
    fun provideStockService(qiitaV2Api:QiitaV2Api) = StockService(qiitaV2Api)

}