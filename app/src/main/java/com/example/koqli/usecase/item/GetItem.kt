package com.example.koqli.usecase.item

import com.example.koqli.domain.comment.Comment
import com.example.koqli.domain.comment.CommentRepository
import com.example.koqli.domain.item.FullItem
import com.example.koqli.domain.item.Item
import com.example.koqli.domain.item.ItemRepository
import com.example.koqli.usecase.BaseRxUseCase
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

/**
 * Created by biwaishi on 2018/03/04.
 */

class GetItem(private val itemId: String): BaseRxUseCase<Item>(){

    @Inject
    lateinit var itemRepository: ItemRepository

    override fun source(): Single<Item> = Single.create{
        itemRepository.getItem(itemId)
    }
}