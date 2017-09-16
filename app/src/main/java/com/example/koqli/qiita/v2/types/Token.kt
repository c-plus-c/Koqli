package com.example.koqli.qiita.v2.types

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Token(

	@field:SerializedName("scopes")
	val scopes: List<String?>? = null,

	@field:SerializedName("client_id")
	val clientId: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)