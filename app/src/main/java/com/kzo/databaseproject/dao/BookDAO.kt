package com.kzo.databaseproject.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kzo.databaseproject.entity.BookEntity

@Dao
interface BookDAO {
    @Insert
    fun saveBooks(book:BookEntity)

    @Query(value = "Select * from BookEntity")
    fun getAllBooks():List<BookEntity>
}