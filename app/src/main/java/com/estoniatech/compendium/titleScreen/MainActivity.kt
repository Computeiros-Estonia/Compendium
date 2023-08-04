package com.estoniatech.compendium.titleScreen

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.estoniatech.compendium.R
import com.estoniatech.compendium.barcodeScanner.BarcodeScannerActivity
import com.estoniatech.compendium.read.BookshelfActivity
import com.estoniatech.compendium.read.SearchActivity
import com.estoniatech.compendium.update.AddBookActivity
import com.estoniatech.compendium.utils.isInternetConnected


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

        val buttonSearch = findViewById<Button>(R.id.buttonCreate)
        buttonSearch.setOnClickListener {
            val intent = Intent(this@MainActivity, SearchActivity::class.java)
            startActivity(intent)
        }
        val buttonRead:Button = findViewById(R.id.buttonRead)
        buttonRead.setOnClickListener {
            val intent = Intent(this@MainActivity, BookshelfActivity::class.java)
            startActivity(intent)
        }

        val buttonScan: Button = findViewById(R.id.buttonScanISBN)
        // Assuming you have a button with the ID buttonScan that leads to BarcodeScannerActivity
        buttonScan.setOnClickListener {
            val intent = Intent(this@MainActivity, BarcodeScannerActivity::class.java)
            startActivity(intent)
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
