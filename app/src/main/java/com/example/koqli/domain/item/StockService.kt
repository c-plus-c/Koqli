package com.example.koqli.domain.item

import com.example.koqli.qiita.v2.QiitaV2Api
import io.reactivex.Observable
import retrofit2.http.DELETE
import retrofit2.http.PUT
import retrofit2.http.Path
import javax.inject.Inject

/**
 * Created by biwaishi on 2017/09/16.
 */

class StockService{
    @Inject
    lateinit var qiitaV2Api: QiitaV2Api

    fun isStockingItem(itemId: String): Observable<Unit?> =
            qiitaV2Api.isStockingItem(itemId)

    fun stockItem(itemId: String): Observable<Unit?> =
            qiitaV2Api.stockItem(itemId)

    fun unstockItem(itemId: String): Observable<Unit?> =
            qiitaV2Api.unstockItem(itemId)
}