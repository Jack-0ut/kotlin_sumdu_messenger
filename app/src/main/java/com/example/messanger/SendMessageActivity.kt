package com.example.messanger

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.messanger.databinding.ActivitySendMessageBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class SendMessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySendMessageBinding;

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendMessageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // click on the send message button
        binding.sendMessageButton.setOnClickListener{
            if(binding.messageInput.text.toString().isNotBlank()){
                /*
                //val formatter = DateTimeFormatter.ofPattern("HH:mm")
                //intent.putExtra("message_text", binding.messageInput.text.toString())
                //intent.putExtra("message_time", LocalDateTime.now().toString())
                val intent = Intent(Intent.ACTION_SEND)
                //val formatter = DateTimeFormatter.ofPattern("HH:mm")
                //intent.putExtra("message_text", binding.messageInput.text.toString())
                //intent.putExtra("message_time", LocalDateTime.now().toString())
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT,binding.messageInput.text.toString())
                startActivity(intent)
                */
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, binding.messageInput.text.toString())
                intent.putExtra("message_text", binding.messageInput.text.toString())
                intent.putExtra("message_time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))
                startActivity(intent)
            }
        }

    }

}