package com.example.koqli.application

import android.content.Context
import com.example.koqli.application.preference.KoqliPreferences

/**
 * Created by biwaishi on 2017/09/10.
 */

class Application: android.app.Application(){
    companion object {

        fun from(context: Context): Application = context.applicationContext as Application
    }

    val securePreference: KoqliPreferences = KoqliPreferences(this)

    val component:  KoqliComponent by lazy{
        DaggerKoqliComponent.builder()
                .domainModule(DomainModule())
                .dataModule(DataModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}