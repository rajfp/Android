package com.example.android

import android.os.Handler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


class NetworkRequestRepository {

    //suspend should be used for non blocking function otherwise it will show redundant. Non blocking means moving to another thread.
    //using suspend allow to run code without blocking and continuing with rest of code apart from coroutine.
    suspend fun makeLoginRequest(): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                delay(2000)
                println("loginRepository = ${Thread.currentThread().name}")
                println("loginRepository = startmakeLoginRequest")
                println("loginRepository = makeLoginRequest")
                Result.Success("Success")

            } catch (e: Exception) {
                Result.Failure("Something went wrong")
            }
        }
    }

    suspend fun makeLogRequest(): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                println("loginRepository = ${Thread.currentThread().name}")
                println("loginRepository = startmakeLoginRequest")
                //Thread.sleep(5000)
                println("loginRepository = makeLogRequest")
                Result.Success("Success2")

            } catch (e: Exception) {
                Result.Failure("Something went wrong")
            }
        }
    }
}

interface RepositoryCallback<T> {
    fun onComplete(result: Result<T>)
}

// IF we use normal threads insted of suspend then it will be a blocking call if we use thread.sleep. It means rest of code wont run until
//sleep finishes

//fun makeLoginRequest(): Result<String> {
//
//    return try {
//        println("loginRepository = ${Thread.currentThread().name}")
//        println("loginRepository = startmakeLoginRequest")
//        Thread.sleep(5000)
//        println("loginRepository = makeLoginRequest")
//        Result.Success("Success")
//
//    } catch (e: Exception) {
//        Result.Failure("Something went wrong")
//    }
//    // }
//}
//
//fun makeLogRequest(): Result<String> {
////        return withContext(Dispatchers.IO) {
//    return try {
//        println("loginRepository = ${Thread.currentThread().name}")
//        println("loginRepository = startmakeLogRequest")
////            Thread.sleep(2000)
//        println("loginRepository = makeLogRequest")
//        Result.Success("Success")
//
//    } catch (e: Exception) {
//        Result.Failure("Something went wrong")
//    }
//}
//}
