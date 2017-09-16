package com.example.koqli.application.preference

import android.content.Context
import com.example.koqli.Settings
import com.rejasupotaro.android.kvs.PrefsBuilder
import com.securepreferences.SecurePreferences

/**
 * Created by biwaishi on 2017/09/11.
 */

class KoqliPreferencesBuilder: PrefsBuilder<KoqliPreferences> {
    override fun build(context: Context?): KoqliPreferences{
        return KoqliPreferences(SecurePreferences(context, Settings.salt, null))
    }
}
