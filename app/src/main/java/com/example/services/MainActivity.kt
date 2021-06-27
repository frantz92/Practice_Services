package com.example.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_start.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                text_view_info_service.text = "Service running"
            }
        }

//        button_stop.setOnClickListener {
//            MyIntentService.stopService()
//            text_view_info_service.text = "Service stopped"
//        }

        button_stop.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                text_view_info_service.text = "Service stopped"
            }
        }

        button_send_data.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = etData.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }
    }
}