package com.arpit.play.billing

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class NetworkRequestRepository {
    var executorService: ExecutorService = Executors.newFixedThreadPool(4)

    fun makeLoginRequest(callback: RepositoryCallback<String>) {
        executorService.execute {
            try {
                println("loginRepository = ${Thread.currentThread().name}")
                Thread.sleep(2000)
                callback.onComplete(Result.Success("Success"))
            } catch (e: Exception) {
                callback.onComplete(Result.Failure("Something went wrong"))
            }
        }
    }
}

interface RepositoryCallback<T> {
    fun onComplete(result: Result<T>)
}