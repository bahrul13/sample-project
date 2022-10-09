package com.example.sampleproject.main.secondfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleproject.data.local.AppDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor (val appDataBase: AppDataBase): ViewModel() {
    val secondText = MutableLiveData<String>("Hello Second fragment")

    fun changeSecondText(text: String){
        secondText.value = text
    }
}
