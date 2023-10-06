package com.example.meuslivros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.meuslivros.databinding.ActivityExibirLivrosBinding

class ExibirLivros : AppCompatActivity() {

    var index :Int = 0
    lateinit var binding:ActivityExibirLivrosBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir_livros)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "appdatabase.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()


        binding= DataBindingUtil.setContentView(this,R.layout.activity_exibir_livros)


        binding.textViewNome.text = db.livroDao().listAll()[index].nome
        binding.textViewAutor.text = db.livroDao().listAll()[index].autor
        binding.textViewAno.text = db.livroDao().listAll()[index].nome

        var livros = db.livroDao().listAll()

        binding.button5.setOnClickListener{
            fun infoLivros(index: Int) {
                binding.textViewNome.text = livros[index].nome
                binding.textViewAutor.text = livros[index].autor
                binding.textViewAno.text = livros[index].ano.toString()
            }


            if (index < livros.size - 1) {
                index ++
                infoLivros(index)
            } else {

            }
        }


//        val livros = db.livroDao().listAll()
//
//        if (livros.isNotEmpty()) {
//            val stringBuilder = StringBuilder()
//            for (livro in livros) {
//                stringBuilder.append(livro.nome).append("\n")
//            }
//            binding.textViewNome.text = stringBuilder.toString()
//        } else {
//            binding.textViewNome.text = "Nenhum livro cadastrado"
//        }

    }

//    fun infoLivros(index: Int) {
//        binding.textViewNome.text = livros[index].nome
//        binding.textViewAutor.text = livros[index].autor
//        binding.textViewAno.text = livros[index].ano.toString()
//    }


}