package com.example.koqli.usecase

/**
 * Created by biwaishi on 2017/09/10.
 */

interface UseCase<out T>{
    fun exec(success:((T) -> Unit), fail: ((Throwable) -> Unit)? = null, finished: (() -> Unit)?)
}