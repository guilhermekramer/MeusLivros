package com.example.meuslivros

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LivroDao {

    @Query("SELECT * FROM livro")
    fun listAll(): Array<Livro>

    @Insert
    fun insert( livro: Livro) : Long



    @Delete
    fun delete(livro: Livro): Int

    @Query("SELECT * FROM livro WHERE nome = :nome")
    fun findByName (nome: String) : Livro

}