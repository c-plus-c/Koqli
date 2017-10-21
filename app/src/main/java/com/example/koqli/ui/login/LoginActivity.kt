package com.example.koqli.ui.login

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.widget.Toast
import com.example.koqli.R
import com.example.koqli.Settings
import com.example.koqli.application.Application
import com.example.koqli.qiita.v2.QiitaV2Api
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.uber.autodispose.kotlin.autoDisposeWith
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.computation
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {


    @Inject
    lateinit var application: Application

    lateinit var loginActivityViewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)


        if(intent != null && intent?.data != null) {
            val authCode = QiitaV2Api.extractAuthCode(intent?.data.toString())
            loginActivityViewModel = LoginActivityViewModel(baseContext, authCode)
            loginActivityViewModel.isLoginSuccess
                    .autoDisposeWith(AndroidLifecycleScopeProvider.from(this))
                    .subscribe {
                it -> Toast.makeText(baseContext,"ログインに成功しました",Toast.LENGTH_SHORT).show()
            }.apply {
                loginActivityViewModel.disposables.add(this)
            }
            loginActivityViewModel.error
                    .autoDisposeWith(AndroidLifecycleScopeProvider.from(this))
                    .subscribe {
                it -> Toast.makeText(baseContext, "失敗だよバーカ！", Toast.LENGTH_SHORT).show()
            }.apply {
                loginActivityViewModel.disposables.add(this)
            }

            loginActivityViewModel.login()
        } else {
            val tabsIntent: CustomTabsIntent = CustomTabsIntent.Builder().build()
            tabsIntent.launchUrl(this, Uri.parse(QiitaV2Api.getQiitaAuthUrl("https://qiita.com/api/v2/oauth/authorize", Settings.clientId,"")))
        }
    }
}
