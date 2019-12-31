package com.kzo.databaseproject.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kzo.databaseproject.dao.BookDAO
import com.kzo.databaseproject.entity.BookEntity

@Database(entities = [(BookEntity::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDAO
}