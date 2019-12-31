package com.kzo.databaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.room.Insert
import androidx.room.Room
import com.kzo.databaseproject.database.AppDatabase
import com.kzo.databaseproject.entity.BookEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var Bid:Int=0
    var Bname:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "BookDB").build()

        var bookId=findViewById<EditText>(R.id.edt_bookId)
        var bookName=findViewById<EditText>(R.id.edt_bookName)

        var Insert=findViewById<Button>(R.id.btn_insert)
        var Show=findViewById<Button>(R.id.btn_show)

        btn_insert.setOnClickListener {
            Bid=bookId.text.toString().toInt()
            Bname=bookName.text.toString()

            var bookEntity = BookEntity()
            bookEntity.bookId = Bid
            bookEntity.bookName = Bname

            db.bookDao().saveBooks(bookEntity)

            db.bookDao().getAllBooks().forEach()
            {
                Log.i("Fetch Records", "Id:  : ${it.bookId}")
                Log.i("Fetch Records", "Name:  : ${it.bookName}")
                //txt_view.text=it.bookName
            }
        }

        btn_show.setOnClickListener {

        }



        //Insert Case
       /* Thread {
            var bookEntity = BookEntity()
            bookEntity.bookId = 1
            bookEntity.bookName = "Kotlin for Android Developer"

            db.bookDao().saveBooks(bookEntity)

            bookEntity.bookId = 2
            bookEntity.bookName = "Java"


            db.bookDao().saveBooks(bookEntity)

            //fetch Records
            db.bookDao().getAllBooks().forEach()
            {
                Log.i("Fetch Records", "Id:  : ${it.bookId}")
                Log.i("Fetch Records", "Name:  : ${it.bookName}")
                //txt_view.text=it.bookName
            }
        }.start()*/
    }
}
