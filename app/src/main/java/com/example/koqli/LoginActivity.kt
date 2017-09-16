package com.example.koqli

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.koqli.qiita.v2.QiitaV2Api
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        intent?.data.let {
            val code = QiitaV2Api.extractAuthCode(it.toString())
            val clientId = Settings.clientId
            val clientSecret = Settings.clientSecret
        }
    }
}
