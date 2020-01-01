package com.kzo.databaseproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.kzo.databaseproject.adapter.BookAdapter
import com.kzo.databaseproject.database.AppDatabase
import com.kzo.databaseproject.entity.BookEntity

class SecondAcivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        var db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "BookDB").build()

        Thread {
            var bookList = ArrayList<BookEntity>()

            var bookEntity = BookEntity()
            bookEntity.bookId = 1
            bookEntity.bookName = "Java"
            db.bookDao().saveBooks((bookEntity))

            bookEntity.bookId = 2
            bookEntity.bookName = "C++"
            db.bookDao().saveBooks((bookEntity))

            bookEntity.bookId = 3
            bookEntity.bookName = "Phython"
            db.bookDao().saveBooks((bookEntity))

            bookEntity.bookId = 4
            bookEntity.bookName = "PHP"
            db.bookDao().saveBooks((bookEntity))

            bookEntity.bookId = 5
            bookEntity.bookName = "JavaScript"
            db.bookDao().saveBooks((bookEntity))


            db.bookDao().getAllBooks().forEach() {
                Log.i("Fruit Record", "Id::${it.bookId}")
                Log.i("Fruit Record", "Name::${it.bookName}")
            }

            var list=db.bookDao().getAllBooks()
            bookList= list as ArrayList<BookEntity>
            val bookAdapter = BookAdapter(bookList)

            recyclerView.adapter = bookAdapter

        }.start()
    }

}
