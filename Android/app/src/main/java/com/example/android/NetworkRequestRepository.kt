package com.example.android

import android.os.Handler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutorService


class NetworkRequestRepository {

    suspend fun makeLoginRequest(): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                println("loginRepository = ${Thread.currentThread().name}")
                Thread.sleep(2000)
                Result.Success("Success")

            } catch (e: Exception) {
                Result.Failure("Something went wrong")
            }
        }
    }
}

interface RepositoryCallback<T> {
    fun onComplete(result: Result<T>)
}