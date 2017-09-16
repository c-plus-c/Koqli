package com.example.koqli.usecase

import com.example.koqli.Settings
import com.example.koqli.application.Application
import com.example.koqli.qiita.v2.QiitaV2Api
import com.example.koqli.qiita.v2.queries.LoginParameter
import com.example.koqli.qiita.v2.types.User
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by biwaishi on 2017/09/10.
 */

class AuthorizeAccount(private val code: String): BaseRxUseCase<User>(){

    @Inject
    lateinit var application: Application

    @Inject
    lateinit var api: QiitaV2Api

    override fun source(): Single<User> {
        return api.login(LoginParameter(clientId = "${Settings.clientId}", clientSecret = "${Settings.clientSecret}",code = code))
                .filter{it.token?.isNotBlank() ?: false}
                .map{application.securePreference.token = it.token}
                .flatMapSingle { api.getAuthenticatedUser() }
                .map{
                    User()
                }.doOnError { application.securePreference.removeToken() }
    }
}