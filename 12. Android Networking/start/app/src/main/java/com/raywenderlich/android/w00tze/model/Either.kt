package com.raywenderlich.android.w00tze.model

data class Either<out T> (val status : Status, val data: T?, val error: ApiError?) {

    companion object {
        fun  <T> succes(data : T?) : Either<T> {
            return Either(Status.SUCCES, data, null)
        }

        fun  <T> error(error: ApiError, data : T?) : Either<T> {
            return Either(Status.ERROR, data, error)
        }

    }



}