package com.example.meuslivros

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Livro::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun livroDao(): LivroDao
}