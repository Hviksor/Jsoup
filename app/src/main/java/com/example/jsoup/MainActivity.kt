package com.example.jsoup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class MainActivity : AppCompatActivity() {
    private var doc: Document? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsoup: Jsoup
        CoroutineScope(Dispatchers.IO).launch {
            getVeb()
        }
    }

    suspend fun getVeb() {

        doc = Jsoup.connect("https://finance.rambler.ru/currencies/?utm_medium=widget")
            .get()
        Log.e("koko", "" + doc?.title())

    }
}