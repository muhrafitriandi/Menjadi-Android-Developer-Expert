package com.dicoding.mysimplelogin.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.core.SessionManager
import com.dicoding.core.UserRepository
import com.dicoding.mysimplelogin.chat.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sesi = SessionManager(this)
        val userRepository = UserRepository.getInstance(sesi)
        binding.tvChat.text = getString(
            R.string.welcome_message,
            "${userRepository.getUser()}! \n Welcome to Chat Feature"
        )
    }
}