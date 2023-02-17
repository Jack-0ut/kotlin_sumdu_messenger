package com.example.messanger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.messanger.databinding.ActivityReceiveMessageBinding
import com.example.messanger.databinding.ActivitySendMessageBinding

class ReceiveMessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReceiveMessageBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiveMessageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.receivedMessage.text =  intent.getStringExtra("message_text")
        binding.dateField.text = intent.getStringExtra("message_time")

        // click on go back button
        binding.goBackButton.setOnClickListener {
            val intent = Intent(this, SendMessageActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}