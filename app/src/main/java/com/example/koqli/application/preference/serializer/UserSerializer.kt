package com.example.koqli.application.preference.serializer

import com.example.koqli.domain.user.User
import com.example.koqli.domain.user.UserConverter
import com.google.gson.Gson
import com.rejasupotaro.android.kvs.serializers.PrefsSerializer

/**
 * Created by biwaishi on 2017/09/16.
 */

class UserSerializer: PrefsSerializer<User?, String?>{

    private val gson:Gson = Gson()

    override fun serialize(src: User?): String? {
        return src?.let{gson.toJson(UserConverter.toData(it))}
    }

    override fun deserialize(src: String?): User? {
        if(src?.isNotBlank() ?:false) {
            return UserConverter.toDomain(gson.fromJson(src, com.example.koqli.qiita.v2.types.User::class.java))
        }else{
            return null
        }
    }
}