package com.example.koqli.ui

import android.content.Context
import com.example.koqli.application.Application
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by biwaishi on 2017/10/16.
 */

interface ViewModel{
    val context:Context
    val application: Application get() = Application.from(context)
    var disposables: CompositeDisposable

    fun create(){

    }

    fun destroy(){
        disposables.clear()
    }
}