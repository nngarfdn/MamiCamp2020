package com.raywenderlich.android.w00tze.repository

import com.raywenderlich.android.w00tze.model.AccesToken
import retrofit2.Call
import retrofit2.http.*

interface AuthApi {
    @Headers("Accept: application/json")
    @POST("login/oauth/acces_token")
    @FormUrlEncoded
    fun getAccesToken(@Field("client_id") clientId : String,
    @Field("client_secret") clientSecret :String,
    @Field("code")  accesCode :String) : Call<AccesToken>
}