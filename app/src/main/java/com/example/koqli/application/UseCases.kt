package com.example.koqli.application

import android.content.Context
import com.example.koqli.usecase.AuthorizeAccount

/**
 * Created by biwaishi on 2017/09/11.
 */

class Usecases(val context: Context){
    private val application: Application get() = Application.from(context)
    private val component: KoqliComponent get() = application.component

    fun getAuthorizeAccount(code: String) = AuthorizeAccount(code).apply { component.inject(this) }
}