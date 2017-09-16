package com.example.koqli.usecase

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by biwaishi on 2017/09/10.
 */
abstract class BaseRxUseCase<T> : RxUseCase<T>{
    private val disposables = CompositeDisposable()
    private var transformer: UseCaseTransformer<T>? = null

    abstract fun source(): Single<T>

    override fun exec(success: (T) -> Unit, fail: ((Throwable) -> Unit)?) {
        if(isDisposed) throw IllegalStateException("Usecase is disposed.")

        source().let { source ->
            transformer?.let{transformer -> source.compose { transformer.invoke(it) }} ?: source
        }.subscribe({
            success.invoke(it)
        },{
            fail?.invoke(it)
        })
    }

    override fun compose(transformer: UseCaseTransformer<T>): RxUseCase<T> {
        this.transformer = transformer
        return this
    }

    override fun dispose() {
        disposables.clear()
    }

    override fun isDisposed(): Boolean = disposables.isDisposed


}