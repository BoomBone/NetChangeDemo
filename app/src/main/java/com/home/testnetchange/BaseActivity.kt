package com.home.testnetchange

import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author Ting
 * @date 2018/7/23.
 */
open abstract class BaseActivity : AppCompatActivity() {

    lateinit var intentFilter: IntentFilter
    lateinit var networkChangeReceivrt: NetworkChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intentFilter = IntentFilter()
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        networkChangeReceivrt = NetworkChangeReceiver()
        registerReceiver(networkChangeReceivrt,intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkChangeReceivrt)
    }
}