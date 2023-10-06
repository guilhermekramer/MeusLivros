package com.example.meuslivros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.meuslivros.databinding.ActivityExibirLivrosBinding

class ExibirLivros : AppCompatActivity() {

    var i :Int = 0
    lateinit var binding:ActivityExibirLivrosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir_livros)

        binding= DataBindingUtil.setContentView(this,R.layout.activity_exibir_livros)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "appdatabase.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()


        binding.textViewNome.text = db.livroDao().listAll()[i].toString()

    }
}