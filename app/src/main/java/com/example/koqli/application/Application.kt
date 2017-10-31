package com.example.koqli.application

import android.content.Context
import com.example.koqli.application.preference.KoqliPreferences

/**
 * Created by biwaishi on 2017/09/10.
 */

class Application: android.app.Application(){
    companion object {

        fun getApplicationFromContext(context: Context): Application = context.applicationContext as Application
    }

    val securePreference: KoqliPreferences get() = KoqliPreferences.get(this)

    val component:  KoqliComponent by lazy{
        DaggerKoqliComponent.builder()
                .domainModule(DomainModule())
                .dataModule(DataModule(this))
                .build()
    }

    val usecases: Usecases by lazy {Usecases(this)}

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}