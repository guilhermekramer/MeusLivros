package com.example.meuslivros

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.meuslivros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding:ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button2.setOnClickListener {
            val intent = Intent(this, TelaCadastro::class.java)
            startActivity(intent)
        }

        binding.button1.setOnClickListener {
            val intent = Intent(this, ExibirLivros::class.java)
            startActivity(intent)

            }


        }
}

