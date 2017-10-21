package com.example.koqli.qiita.v2

import android.net.Uri
import com.example.koqli.qiita.v2.queries.LoginParameter
import com.example.koqli.qiita.v2.types.Item
import com.example.koqli.qiita.v2.types.Tag
import com.example.koqli.qiita.v2.types.Token
import com.example.koqli.qiita.v2.types.User
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.HttpUrl
import retrofit2.http.*

/**
 * Created by biwaishi on 2017/09/09.
 */

interface QiitaV2Api{
    companion object {
        fun getQiitaAuthUrl(apiUrl: String, clientId: String, state: String): String{
            return HttpUrl.parse("$apiUrl")?.newBuilder()
                    ?.addQueryParameter("scope", "read_qiita write_qiita")
                    ?.addQueryParameter("state", state)
                    ?.addQueryParameter("client_id",clientId)
                    .toString()
        }

        fun extractAuthCode(url: String): String?{
            return Uri.parse(url).getQueryParameter("code")
        }
    }

    @POST("access_tokens")
    fun login(@Body loginParameter: LoginParameter): Single<Token>

    @GET("authenticated_user")
    fun getAuthenticatedUser(): Single<User>

    @GET("items")
    fun getItems(@Query("page") page: Int, @Query("per_page") perPage: Int): Single<MutableList<Item>>

    @GET("items")
    fun getItemsByKeyword(@Query("query") query: String, @Query("page") page: Int, @Query("per_page") perPage: Int): Single<MutableList<Item>>

    @GET("tags/{tag_id}/items")
    fun getItemsByTagId(@Path("tag_id") tagId: String, @Query("page") page: Int, @Query("per_page") perPage: Int): Single<MutableList<Item>>

    @GET("tags")
    fun getTags(@Query("page") page: Int, @Query("per_page") perPage: Int): Single<MutableList<Tag>>

    @GET("users/{user_id}/following_tags")
    fun getTagsByUserId(@Path("user_id") userId: String, @Query("page") page: Int, @Query("per_page") perPage: Int): Single<MutableList<Tag>>

    @GET("tags/{tag_id}")
    fun getTagById(@Path("tag_id") tagId: String): Single<Tag>

    @GET("items/{item_id}/stock")
    fun isStockingItem(@Path("item_id") itemId: String): Observable<Unit?>

    @PUT("items/{item_id}/stock")
    fun stockItem(@Path("item_id") itemId: String): Observable<Unit?>

    @DELETE("items/{item_id}/stock")
    fun unstockItem(@Path("item_id") itemId: String): Observable<Unit?>
}
