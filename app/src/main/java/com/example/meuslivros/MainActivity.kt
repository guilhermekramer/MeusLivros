package com.example.meuslivros

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    val db:AppDatabase by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java,"RoomDatabase").allowMainThreadQueries().build()

    }



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCadastrar = findViewById<Button>(R.id.button2)
        val buttonListarLivros = findViewById<Button>(R.id.button1)

        buttonCadastrar.setOnClickListener {
            val intent = Intent(this, TelaCadastro::class.java)
            startActivity(intent)
        }

        buttonListarLivros.setOnClickListener {
            val intent = Intent(this, ExibirLivros::class.java)
            startActivity(intent)

            }


        }
}

