package com.example.messanger

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.messanger.databinding.ActivitySendMessageBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class SendMessageActivity : AppCompatActivity() {
    private val TAG = "States"
    private lateinit var binding: ActivitySendMessageBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendMessageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // click on the send message button
        binding.sendMessageButton.setOnClickListener{
            // if input field is not blank
            if(binding.messageInput.text.toString().isNotBlank()){
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, binding.messageInput.text.toString())
                intent.putExtra("message_text", binding.messageInput.text.toString())
                intent.putExtra("message_time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))
                Toast.makeText(this,"Message has been sent",Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }else{
                Toast.makeText(this,"Enter something to send the message",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"SendMessageActivity: onRestart()")
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"SendMessageActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"SendMessageActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"SendMessageActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"SendMessageActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"SendMessageActivity: onDestroy()")
    }

}