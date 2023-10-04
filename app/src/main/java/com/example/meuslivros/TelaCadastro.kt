package com.example.meuslivros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class TelaCadastro : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)
        val buttonCancelar = findViewById<Button>(R.id.button10)

        buttonCancelar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        fun exibirSnackbar(mensagem: String) {
            val rootView = findViewById<View>(android.R.id.content)
            val snackbar = Snackbar.make(rootView, mensagem, Snackbar.LENGTH_SHORT)
            snackbar.show()
        }
        exibirSnackbar("Livro salvo com sucesso!")
    }



    }
