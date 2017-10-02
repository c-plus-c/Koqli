package com.example.koqli.application

import android.content.Context
import com.example.koqli.usecase.AuthorizeAccount
import com.example.koqli.usecase.item.*
import com.example.koqli.usecase.tag.GetTagById
import com.example.koqli.usecase.tag.GetTags
import com.example.koqli.usecase.tag.GetTagsByUserId

/**
 * Created by biwaishi on 2017/09/11.
 */

class Usecases(val context: Context){
    private val application: Application get() = Application.from(context)
    private val component: KoqliComponent get() = application.component

    fun getAuthorizeAccount(code: String) = AuthorizeAccount(code).apply { component.inject(this) }

    fun getItems(page: Int, perPage: Int) = GetItems(page, perPage).apply { component.inject(this) }

    fun getItemsByKeyword(query: String, page: Int, perPage: Int) = GetItemsByKeyword(query, page, perPage).apply{component.inject(this)}

    fun getItemsByTagId(tagId: String, page: Int, perPage: Int) = GetItemsByTagId(tagId, page, perPage).apply{component.inject(this)}

    fun getTags(page: Int, perPage: Int) = GetTags(page, perPage).apply{component.inject(this)}

    fun getTagsByUserId(userId: String, page: Int, perPage: Int) = GetTagsByUserId(userId, page, perPage).apply{component.inject(this)}

    fun getTagById(tagId: String) = GetTagById(tagId).apply{component.inject(this)}

    fun isStockingItem(itemId: String) = IsStockingItem(itemId).apply{component.inject(this)}

    fun stockItem(itemId: String) = StockItem(itemId).apply{component.inject(this)}

    fun unstockItem(itemId: String) = UnstockItem(itemId).apply{component.inject(this)}

}