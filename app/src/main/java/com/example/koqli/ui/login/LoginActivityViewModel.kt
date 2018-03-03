package com.example.koqli.ui.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.koqli.application.Application
import com.example.koqli.application.Usecases
import com.example.koqli.ui.ViewModelBase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by biwaishi on 2017/10/16.
 */

class LoginActivityViewModel : ViewModelBase() {

    val isLoginSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<Throwable> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun login(usecases: Usecases, code: String) {
        code?.let {
            isLoading.postValue(true)
            usecases.getAuthorizeAccount(it)
            .exec({
                isLoginSuccess.postValue(true)
            }, {
                error.postValue(it)
            }, {
                isLoading.postValue(false)
            }
            )
        }
    }
}