package com.example.koqli.usecase.item

import com.example.koqli.domain.item.Item
import com.example.koqli.domain.item.ItemRepository
import com.example.koqli.usecase.BaseRxUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by biwaishi on 2017/10/02.
 */

class GetItemsByKeyword (private val query: String, private val page: Int, private val perPage: Int): BaseRxUseCase<List<Item>>(){

    @Inject
    lateinit var itemRepository: ItemRepository;

    override fun source(): Single<List<Item>> =
            itemRepository.getItemsByKeyword(query, page, perPage)
}