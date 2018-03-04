package com.example.koqli.domain.comment

import com.example.koqli.domain.item.Item
import com.example.koqli.domain.item.ItemConverter
import com.example.koqli.qiita.v2.QiitaV2Api
import io.reactivex.Single

/**
 * Created by biwaishi on 2018/03/04.
 */

class CommentRepository(private val qiitaV2Api: QiitaV2Api) {
    fun getCommentsByItemId(itemId: String): Single<List<Comment>> =
            qiitaV2Api.getCommentsByItemId(itemId).map{ CommentConverter.toDomains(it)}
}