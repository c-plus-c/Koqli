package com.example.koqli.ui.screen.items.all

import com.example.koqli.application.Application
import com.example.koqli.application.Usecases
import com.example.koqli.domain.item.Item
import com.example.koqli.ui.screen.items.ItemListFragmentViewModel
import com.example.koqli.usecase.BaseRxUseCase

/**
 * Created by biwaishi on 2018/03/04.
 */

class AllListFragmentViewModel: ItemListFragmentViewModel(){
    override fun getItems(application: Application, currentPage: Int): BaseRxUseCase<List<Item>> {
        return application.usecases.getItems(currentPage, PER_PAGE)
    }
}