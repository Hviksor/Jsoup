package com.example.jsoup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class KokoViewModel : ViewModel() {
    val repo = Repository
    val myCourse: MutableLiveData<ArrayList<ItemClass>> = MutableLiveData()
    fun getData() {


        CoroutineScope(Dispatchers.IO).launch {
            val koko = repo.getVeb()
            withContext(Dispatchers.Main) {
                myCourse.value = koko
            }
        }
    }
}