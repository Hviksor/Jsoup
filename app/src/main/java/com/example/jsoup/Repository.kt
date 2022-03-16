package com.example.jsoup

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

object Repository {

    suspend fun getVeb(): ArrayList<ItemClass> {
        val list = ArrayList<ItemClass>()
        val doc = Jsoup.connect("https://minfin.com.ua/currency/").get()
        val table: Elements? = doc.getElementsByTag("tbody")
        val ourTable = table?.get(0)

        val arraySize = ourTable?.childrenSize()

        if (arraySize != null) {
            for (i in 0 until arraySize) {
                val data_1 = ourTable.children()[i].child(0).text()
                val data_2 = ourTable.children()[i].child(1).text().substring(0,7)
                val data_3 = ourTable.children()[i].child(2).text().substring(0,7)
                val data_4 = ourTable.children()[i].child(3).text().substring(0,7)
                val itemClass = ItemClass(data_1, data_2, data_3, data_4)
                list.add(itemClass)
            }
        }
        return list
    }
}