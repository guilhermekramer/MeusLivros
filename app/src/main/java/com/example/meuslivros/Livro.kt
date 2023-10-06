package com.example.meuslivros

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = arrayOf(Index(value = ["id", "nome", "autor", "ano", "nota"])))
class Livro(


    val nome: String,
    val autor: String,
    val ano: Int,
    val nota: String

){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}