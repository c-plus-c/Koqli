package com.example.koqli.domain.item

import com.example.koqli.qiita.v2.QiitaV2Api
import io.reactivex.Single

/**
 * Created by biwaishi on 2017/09/16.
 */

class StockService(private val qiitaV2Api: QiitaV2Api) {

    fun isStockingItem(itemId: String): Single<Boolean> =
            qiitaV2Api.isStockingItem(itemId).map { true }.singleOrError()

    fun stockItem(itemId: String): Single<Boolean> =
            qiitaV2Api.stockItem(itemId).map { true }.singleOrError()

    fun unstockItem(itemId: String): Single<Boolean> =
            qiitaV2Api.unstockItem(itemId).map { true }.singleOrError()
}