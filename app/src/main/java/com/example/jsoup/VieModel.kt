package com.example.jsoup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class VVVieModel : ViewModel() {
    val repo = Repository
    val myCourse: MutableLiveData<ArrayList<ItemClass>> = MutableLiveData()
    fun getData() {
        viewModelScope.launch {
            myCourse.value = repo.getVeb()
        }
    }
}
