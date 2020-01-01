package com.kzo.databaseproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kzo.databaseproject.R
import com.kzo.databaseproject.entity.BookEntity


class BookAdapter(val bookList: ArrayList<BookEntity>) :
    RecyclerView.Adapter<BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_third, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {

        return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        holder.bookId.text = bookList[position].bookId.toString()
        holder.bookName.text = bookList[position].bookName
    }

}

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val bookId = itemView.findViewById<TextView>(R.id.txt_bId)
    val bookName = itemView.findViewById<TextView>(R.id.txt_bName)

}
