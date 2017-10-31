package com.example.koqli.ui.login

import android.content.Context
import com.example.koqli.ui.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import jp.keita.kagurazaka.rxproperty.RxProperty

/**
 * Created by biwaishi on 2017/10/16.
 */

class LoginActivityViewModel(override val context: Context, val code: String?): ViewModel {

    val isLoginSuccess: RxProperty<Boolean> = RxProperty()
    val error: RxProperty<Throwable> = RxProperty()
    override var disposables: CompositeDisposable = CompositeDisposable()

    fun login() {
        code?.let {
            application.usecases.getAuthorizeAccount(it).compose {
                it.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
            }.apply {
                disposables.add(this)
            }.exec({
                isLoginSuccess.set(true)
            }, {
                error.set(it)
            }
            )
        }
    }
}