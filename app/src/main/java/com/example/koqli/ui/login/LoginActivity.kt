package com.example.koqli.ui.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.koqli.Settings
import com.example.koqli.application.Application
import com.example.koqli.qiita.v2.QiitaV2Api
import com.example.koqli.ui.screen.MainScreenActivity
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {


    @Inject
    lateinit var application: Application

    private lateinit var loginActivityViewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Application.getApplicationFromContext(this)?.securePreference?.hasToken()) {
            val nextIntent = Intent(this, MainScreenActivity::class.java)
            startActivity(nextIntent)
        } else if (intent != null && intent?.data != null) {
            val authCode = QiitaV2Api.extractAuthCode(intent?.data.toString())
            loginActivityViewModel = ViewModelProviders.of(this).get(LoginActivityViewModel::class.java)

            loginActivityViewModel.isLoginSuccess
                    .observe(this, Observer {
                        Toast.makeText(baseContext, "ログインに成功しました", Toast.LENGTH_SHORT).show()
                        val nextIntent = Intent(this, MainScreenActivity::class.java)
                        startActivity(nextIntent)
                    })

            loginActivityViewModel.error
                    .observe(this, Observer { it ->
                        Toast.makeText(baseContext, "失敗だよバーカ！", Toast.LENGTH_SHORT).show()
                    })

            authCode?.let {
                loginActivityViewModel.login(Application.getApplicationFromContext(applicationContext).usecases, authCode)
            }
        } else {
            val tabsIntent: CustomTabsIntent = CustomTabsIntent.Builder().build()
            tabsIntent.launchUrl(this, Uri.parse(QiitaV2Api.getQiitaAuthUrl("https://qiita.com/api/v2/oauth/authorize", Settings.clientId, "")))
        }
    }
}
