package com.example.android

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope

class MainActivity : ComponentActivity() {
    private val model = NetworkViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeData(model)
    }

    private fun observeData(model: NetworkViewModel) {
        model.data.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    fun doAction(view:View) {
        val app = (application as MyApplication)
        model.makeLoginRequest(app.threadPoolExecutor, app.mainThreadHandler)
    }
}
