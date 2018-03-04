package com.example.koqli.usecase.item

import com.example.koqli.application.Application
import com.example.koqli.domain.item.Item
import com.example.koqli.domain.item.ItemRepository
import com.example.koqli.domain.tag.Tag
import com.example.koqli.domain.tag.TagRepository
import com.example.koqli.usecase.BaseRxUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by biwaishi on 2018/03/04.
 */
class GetTagFeedItems(private val page: Int, private val perPage: Int) : BaseRxUseCase<List<Item>>(){

    private val tagRequestRange = (1..3)
    @Inject
    lateinit var application: Application

    @Inject
    lateinit var tagRepository: TagRepository

    @Inject
    lateinit var itemRepository: ItemRepository

    override fun source(): Single<List<Item>> {
        val authenticatedUser = application.authenticatedUser

        return authenticatedUser?.id?.let {
            userId ->
            val tagsRequests = tagRequestRange.map {
                tagRepository.getTagsByUserId(userId, it, 100)
            }
            Single.merge(tagsRequests)
                    .filter{it.isNotEmpty()}
                    .map{it.map(Tag::identity)}
                    .flatMapSingle { itemRepository.getTagFeedItems(it, page, 10) }
                    .collectInto(mutableListOf<Item>(), {result, items -> result.addAll(items)})
                    .map{it.toList()}
        } ?: Single.error<List<Item>>(IllegalStateException("Unauthenticated"))
    }
}