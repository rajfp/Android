package com.arpit.play.billing

import kotlin.Result

sealed class Result<T>(val isSuccess: Boolean, val data: T?, val error: String?) {

    class Success<T>(info: T) :
        com.arpit.play.billing.Result<T>(true, data = info, null)

    class Failure<T>(msg: String) :
        com.arpit.play.billing.Result<T>(false, null, msg)
}