package com.example.threads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var button2: Button
    private val handler: Handler = Handler(Looper.getMainLooper())
    private val textDone = "done"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun doSomethingLong() {
        button2 = findViewById(R.id.button2)
        try {
            println("long operation start")
            Thread.sleep(2000)
            handler.post {
                run {
                    button2.text = textDone
                }
            }

            println("long operation stop")
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun buttonClick(view: View) {
        doSomethingLong()
    }
}