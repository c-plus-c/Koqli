package com.example.koqli.qiita.v2.queries

import com.google.gson.annotations.SerializedName

/**
 * Created by biwaishi on 2017/09/10.
 */

data class LoginParameter(
    @SerializedName("client_id")
    val clientId: String,

    @SerializedName("client_secret")
    val clientSecret: String,

    val code: String
)
