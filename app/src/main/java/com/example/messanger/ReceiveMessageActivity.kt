package com.example.messanger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.messanger.databinding.ActivityReceiveMessageBinding

class ReceiveMessageActivity : AppCompatActivity() {
    private val TAG = "States"
    private lateinit var binding: ActivityReceiveMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiveMessageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // if we have state saved, use it
        if (savedInstanceState != null) {
            binding.receivedMessage.text = savedInstanceState.getString("message") ?: ""
            binding.dateField.text = savedInstanceState.getString("date") ?: ""
        }
        binding.receivedMessage.text =  intent.getStringExtra("message_text").toString()
        binding.dateField.text  = intent.getStringExtra("message_time").toString()

        // click on go back button
        binding.goBackButton.setOnClickListener {
            val intent = Intent(this, SendMessageActivity::class.java)
            startActivity(intent)
        }
    }
    // save state (message,date)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("message",binding.receivedMessage.text.toString())
        outState.putString("date", binding.dateField.text.toString())
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"ReceiveMessageActivity: onRestart()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"ReceiveMessageActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"ReceiveMessageActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"ReceiveMessageActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"ReceiveMessageActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"ReceiveMessageActivity: onDestroy()")
    }
}
