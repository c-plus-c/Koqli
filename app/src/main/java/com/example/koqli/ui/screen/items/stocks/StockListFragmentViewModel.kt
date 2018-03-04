package com.example.koqli.ui.screen.items.stocks

import com.example.koqli.application.Application
import com.example.koqli.domain.item.Item
import com.example.koqli.ui.screen.items.ItemListFragmentViewModel
import com.example.koqli.usecase.BaseRxUseCase

/**
 * Created by biwaishi on 2018/03/04.
 */
class StockListFragmentViewModel : ItemListFragmentViewModel() {
    override fun getItems(application: Application, currentPage: Int): BaseRxUseCase<List<Item>> {
        application?.authenticatedUser?.id?.let {
            return application.usecases.getStockedItems(it, currentPage, PER_PAGE)
        } ?: run {
            throw IllegalStateException()
        }
    }

}