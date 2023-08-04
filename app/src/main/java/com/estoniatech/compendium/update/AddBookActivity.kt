package com.estoniatech.compendium.update

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.estoniatech.compendium.R
import com.estoniatech.compendium.barcodeScanner.BarcodeScannerActivity
import com.estoniatech.compendium.model.Book
import com.estoniatech.compendium.model.room.RoomInstance
import com.estoniatech.compendium.utils.isInternetConnected
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddBookActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_book_details)
//
//        // Check internet connectivity before making an API call
//        if (isInternetConnected(this)) {
//            try {
//                // Implement the API call and auto-fill logic here (if available).
//                // Display a loading indicator or progress bar while fetching data.
//            } catch (e: Exception) {
//                showInternetConnectionDialog()
//            }
//        } else {
//            showInternetConnectionDialog()
//        }
//
//        val formTitle: EditText = findViewById(R.id.formsTitle)
//        val formAuthor: EditText = findViewById(R.id.formsAuthor)
//        val formPublisher: EditText = findViewById(R.id.formsPublisher)
//        val formPublicationYear: EditText = findViewById(R.id.formsPublicationYear)
//        val compendiumDao = RoomInstance.getDatabase(this).getCompendiumDao()
//
//        val buttonCreate: Button = findViewById(R.id.buttonDone)
//        buttonCreate.setOnClickListener {
//            val newBook = Book(
//                0,
//                formTitle.text.toString(),
//                formAuthor.text.toString(),
//                formPublisher.text.toString(),
//                formPublicationYear.text.toString()
//            )
//            CoroutineScope((Dispatchers.Main)).launch {
//                compendiumDao.insertBook(newBook)
//            }
//            finish()
//        }
//    }
//    private fun showInternetConnectionDialog() {
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Internet Connection Error")
//        builder.setMessage("Please connect to the internet to perform this action.")
//        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
//        val dialog = builder.create()
//        dialog.show()
//    }
}
