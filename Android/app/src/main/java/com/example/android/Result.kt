package com.example.android

sealed class Result<T>(val isSuccess: Boolean, val data: T?, val error: String?) {

    class Success<T>(info: T) :
        com.example.android.Result<T>(true, data = info, null)

    class Failure<T>(msg: String) :
        com.example.android.Result<T>(false, null, msg)
}