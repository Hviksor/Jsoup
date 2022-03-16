package com.example.jsoup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import com.example.jsoup.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class MainActivity : AppCompatActivity() {

    lateinit var adapter: RVAdapter
    lateinit var binding: ActivityMainBinding
    private var tableTemp: Element? = null

    var job: Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[KokoViewModel::class.java]
        adapter = RVAdapter()
        binding.rcView.adapter = adapter

        viewModel.getData()
        viewModel.myCourse.observe(this) { adapter.updateAdapter(it) }
    }


//        Log.e("koko", "" + tableTemp?.children()?.get(1)?.text())


//    private suspend fun getVeb(): Element? {
//        doc = Jsoup.connect("https://minfin.com.ua/currency/").get()
//        val table: Elements? = doc?.getElementsByTag("tbody")
//        val ourTable = table?.get(0)
////        val elementsFromTable = ourTable?.children()
////        val dollar = elementsFromTable?.get(0)
////        val dollarElements = dollar?.children()
//        return ourTable
}