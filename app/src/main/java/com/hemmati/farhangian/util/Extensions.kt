package com.hemmati.farhangian.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

@Suppress("DEPRECATION")
fun Fragment.isNetworkAvailable(): Boolean {
    val connectivityManager =
        activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    val networks = connectivityManager.allNetworks
    var hasInternet = false
    if (networks.isNotEmpty()) {
        for (network in networks) {
            val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
            if (networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true) hasInternet =
                true
        }
    }
    return hasInternet
}

inline fun <T : View> T.showIf(condition: (T) -> Boolean) {
    visibility = if (condition(this)) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

fun Fragment.showToast(text: String) {
    Toast.makeText(
        activity, text,
        Toast.LENGTH_LONG
    ).show()
}

@SuppressLint("HardwareIds")
inline fun Fragment.getDeviceId(): String {
    return Settings.Secure.getString(
        activity?.contentResolver,
        Settings.Secure.ANDROID_ID
    )
}