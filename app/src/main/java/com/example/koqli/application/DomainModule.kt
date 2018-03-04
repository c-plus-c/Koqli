package com.example.koqli.application

import com.example.koqli.domain.comment.CommentRepository
import com.example.koqli.domain.item.ItemRepository
import com.example.koqli.domain.item.StockService
import com.example.koqli.domain.tag.TagRepository
import com.example.koqli.qiita.v2.QiitaV2Api
import dagger.Module
import dagger.Provides

/**
 * Created by biwaishi on 2017/09/10.
 */

@Module
class DomainModule{

    @Provides
    fun provideItemRepository(qiitaV2Api: QiitaV2Api) = ItemRepository(qiitaV2Api)

    @Provides
    fun provideTagRepository(qiitaV2Api: QiitaV2Api) = TagRepository(qiitaV2Api)

    @Provides
    fun provideCommentRepository(qiitaV2Api: QiitaV2Api) = CommentRepository(qiitaV2Api)

    @Provides
    fun provideStockService(qiitaV2Api:QiitaV2Api) = StockService(qiitaV2Api)

}