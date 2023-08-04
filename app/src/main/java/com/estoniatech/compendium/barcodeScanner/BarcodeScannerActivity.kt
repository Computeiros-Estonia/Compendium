package com.estoniatech.compendium.barcodeScanner

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.estoniatech.compendium.R
import com.estoniatech.compendium.utils.isInternetConnected

class BarcodeScannerActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE_SCAN = 123
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barcode_scanner)

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

        val scanButton: Button = findViewById(R.id.buttonScan) // Correct Button ID for activity_barcode_scanner.xml
        scanButton.setOnClickListener {
            // Launch the barcode scanner
            val intent = Intent("com.google.zxing.client.android.SCAN")
            intent.putExtra("SCAN_MODE", "ONE_D_MODE")
            startActivityForResult(intent, REQUEST_CODE_SCAN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_SCAN) {
            if (resultCode == Activity.RESULT_OK) {
                val scannedISBN: String? = data?.getStringExtra("SCAN_RESULT")
                // Here you can proceed with fetching data from Amazon's API using the ISBN.
                // Implement the API call and auto-fill logic here.
                // Display a loading indicator or progress bar while fetching data.
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
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
