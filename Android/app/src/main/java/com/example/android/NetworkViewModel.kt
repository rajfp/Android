package com.example.android

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService

class NetworkViewModel : ViewModel() {
    private val loginRepository: NetworkRequestRepository = NetworkRequestRepository()
    val data = MutableLiveData<String>()
    fun makeLoginRequest(executorService: ExecutorService, mainThreadHandler: Handler) {
        //We can use dispatchers.IO here and remove withContext(Dispatchers.IO) from repository or do like currently done.
        //switch to Background here or switch to Background in repository using withContext(Dispatchers.IO)
        // and stay here in main thread or vice versa.

        viewModelScope.launch {
            when (val result = loginRepository.makeLoginRequest()) {
                is Result.Success -> {
                    //If set called here app will crash because set data is not allowed on background thread, either first switch to main
                    // thread using handler.
                    println("loginRepository = view model ${Thread.currentThread().name}")
                    data.value = "Success"
                    println("loginRepository = ${result.data}")
                }

                is Result.Failure -> {
                    data.value = ("Failure")
                    println("loginRepository = ${result.error}")
                }
            }
        }
    }

}
