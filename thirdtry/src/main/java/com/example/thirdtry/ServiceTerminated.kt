package com.example.thirdtry

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.thirdtry.databinding.ActivityServiceTerminatedBinding

class ServiceTerminated : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(0,0)
        val binding = ActivityServiceTerminatedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener { _ ->
            Toast.makeText(this, "menu item1 실행", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}