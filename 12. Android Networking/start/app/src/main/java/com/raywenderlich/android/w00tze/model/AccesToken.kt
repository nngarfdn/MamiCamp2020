package com.raywenderlich.android.w00tze.model

import com.google.gson.annotations.SerializedName

class AccesToken (
        @SerializedName("acces_token") val accesToken: String,
        @SerializedName("token_type") val tokenType : String)