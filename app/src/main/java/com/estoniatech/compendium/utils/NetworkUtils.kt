package com.estoniatech.compendium.utils

import android.content.Context
import android.net.ConnectivityManager

fun isInternetConnected(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    val activeNetwork = connectivityManager?.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting
}
