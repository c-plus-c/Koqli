package com.example.koqli.ui

import android.arch.lifecycle.ViewModel
import com.example.koqli.application.Usecases
import io.reactivex.disposables.CompositeDisposable

abstract class ViewModelBase(): ViewModel(){

    val disposables: CompositeDisposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}