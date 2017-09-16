package com.example.koqli.usecase

import io.reactivex.Single
import io.reactivex.disposables.Disposable
/**
 * Created by biwaishi on 2017/09/10.
 */

typealias UseCaseTransformer<T> = (Single<T>) -> Single<T>

interface RxUseCase<T> : UseCase<T>, Disposable {
    fun compose(transformer: UseCaseTransformer<T>): RxUseCase<T>
}