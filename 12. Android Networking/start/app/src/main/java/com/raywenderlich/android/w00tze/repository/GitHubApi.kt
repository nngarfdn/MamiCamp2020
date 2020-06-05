package com.raywenderlich.android.w00tze.repository

import com.raywenderlich.android.w00tze.model.*
import retrofit2.Call
import retrofit2.http.*

interface GitHubApi {

    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Call<List<Repo>>

    @GET("users/{user}/gists")
    fun getGists(@Path("user") user: String): Call<List<Gist>>

    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Call<User>

    @POST("gists")
    fun postGist(@Body body : GistRequest) : Call<Gist>

    @DELETE("gists{id}")
    fun deleteGists(@Path("id") gistId : String) : Call<EmptyResponse>

    @PATCH ("user")
    fun updateUser(@Body body: UserRequest) : Call<User>

}