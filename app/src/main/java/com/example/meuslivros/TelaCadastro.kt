package com.example.meuslivros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.meuslivros.databinding.ActivityTelaCadastroBinding

import androidx.room.Room.databaseBuilder
import com.google.android.material.snackbar.Snackbar

class TelaCadastro : AppCompatActivity() {

    lateinit var binding:ActivityTelaCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)
        val db = databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "appdatabase.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()



        binding.button10.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        binding.buttonSalvar.setOnClickListener{
            val nome =binding.editTextText4.text.toString()
            val autor=binding.editTextText5.text.toString()
            val ano = Integer.parseInt(binding.editTextText6.text.toString())
            val nota = binding.ratingBar.rating.toString()

            val livro = Livro(nome, autor, ano, nota)
            db.livroDao().insert(livro)
            val i= Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        fun exibirSnackbar(mensagem: String) {
            val rootView = findViewById<View>(android.R.id.content)
            val snackbar = Snackbar.make(rootView, mensagem, Snackbar.LENGTH_SHORT)
            snackbar.show()
        }
        exibirSnackbar("Livro salvo com sucesso!")
    }



    }
