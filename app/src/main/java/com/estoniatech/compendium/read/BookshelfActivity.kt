package com.estoniatech.compendium.read

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.estoniatech.compendium.R
import com.estoniatech.compendium.model.Book
import com.estoniatech.compendium.model.room.RoomInstance
import com.estoniatech.compendium.utils.isInternetConnected

class BookshelfActivity : AppCompatActivity() {
    private lateinit var bookList: LiveData<List<Book>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookshelf)
        // Check internet connectivity before making an API call
        if (isInternetConnected(this)) {
            try {
                // Implement the API call and auto-fill logic here (if available).
                // Display a loading indicator or progress bar while fetching data.
            } catch (e: Exception) {
                showInternetConnectionDialog()
            }
        } else {
            showInternetConnectionDialog()
        }
        val compendiumDao = RoomInstance.getInstance(this).getCompendiumDao()

        val bookRecyclerView: RecyclerView = findViewById(R.id.shelf_recyclerView)
        val bookshelfAdapter = BookshelfAdapter()
        bookRecyclerView.adapter = bookshelfAdapter

        bookList = compendiumDao.getBookList()
        if (::bookList.isInitialized) {
            bookList.observe(this@BookshelfActivity) { list ->
                bookshelfAdapter.setBookList(list)
            }
        }

    }



    private fun showInternetConnectionDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Internet Connection Error")
        builder.setMessage("Please connect to the internet to perform this action.")
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.show()
    }
}


