package com.example.koqli.usecase.item

import com.example.koqli.domain.item.StockService
import com.example.koqli.usecase.BaseRxUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by biwaishi on 2017/10/02.
 */

class IsStockingItem(private val itemId: String) : BaseRxUseCase<Boolean>() {

    @Inject
    lateinit var stockService: StockService

    override fun source(): Single<Boolean> =
            stockService.isStockingItem(itemId)

}