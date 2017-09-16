package com.example.koqli.application.preference

import com.rejasupotaro.android.kvs.annotations.Key
import com.rejasupotaro.android.kvs.annotations.Table

/**
 * Created by biwaishi on 2017/09/11.
 */

@Table(name = "koqlipreference", builder =KoqliPreferencesBuilder::class)
class KoqliPreferencesSchema {
    @Key(name = "token") var token: String? = null
}
