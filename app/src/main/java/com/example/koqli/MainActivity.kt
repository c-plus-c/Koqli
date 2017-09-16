package com.example.koqli

import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.koqli.qiita.v2.QiitaV2Api

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabsIntent: CustomTabsIntent = CustomTabsIntent.Builder()
                .build()

        tabsIntent.launchUrl(this, Uri.parse(QiitaV2Api.getQiitaAuthUrl("https://qiita.com/api/v2","","")))
    }
}
