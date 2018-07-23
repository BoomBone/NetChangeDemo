package com.home.testnetchange

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import org.jetbrains.anko.toast

/**
 * @author Ting
 * @date 2018/7/23.
 */
class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = manager.activeNetworkInfo
        if (netInfo != null && netInfo.isAvailable) {
            Log.e("net", "当前网络可用")
            context.toast("当前网络可用")
        } else {
            context.toast("当前网络不可用")
            Log.e("net", "当前网络不可用")
        }
    }
}