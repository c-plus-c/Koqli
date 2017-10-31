package com.example.koqli.application

import com.example.koqli.Settings
import com.example.koqli.qiita.v2.QiitaV2Api
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.securepreferences.SecurePreferences
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by biwaishi on 2017/09/11.
 */
@Module
class DataModule(private val application: Application){
    private val gson: Gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()

    private val retrofit: Retrofit = Retrofit.Builder()
            .client(OkHttpClient.Builder().apply {
                addInterceptor {
                    it.proceed(it.request().newBuilder().apply {
                        application.securePreference.token?.let{
                            if(it.isNotBlank())
                                header("Authorization", "Bearer $it")
                        }
                    }.build())}
                }.build())
            .baseUrl("${Settings.qiita.apiUrl}")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun provideApplicationContext() = application

    @Provides
    fun provideSecuredSharedPreference() = SecurePreferences(application)

    @Provides
    fun provideQiitaV2Api() = retrofit.create(QiitaV2Api::class.java)
}