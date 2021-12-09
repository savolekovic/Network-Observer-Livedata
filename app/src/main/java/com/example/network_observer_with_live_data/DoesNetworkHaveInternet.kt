package com.example.network_observer_with_live_data

import android.content.ContentValues
import android.util.Log
import java.io.IOException
import java.net.InetSocketAddress
import javax.net.SocketFactory

object DoesNetworkHaveInternet {

    //Execute this on background thread
    fun execute(socketFactory: SocketFactory): Boolean{
        return try{
            Log.d(ContentValues.TAG,"Pinging GOOGLE.")
            val socket = socketFactory.createSocket() ?: throw IOException("Socket is null.")
            socket.connect(InetSocketAddress("8.8.8.8",53), 1500)
            socket.close()
            Log.d(ContentValues.TAG,"Ping success.")
            true
        }catch (e: IOException){
            Log.d(ContentValues.TAG,"No internet connection. $e")
            false
        }
    }
}