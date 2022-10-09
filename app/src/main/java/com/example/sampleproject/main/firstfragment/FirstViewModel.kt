package com.example.sampleproject.main.firstfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleproject.data.local.AppDataBase
import com.example.sampleproject.data.local.entity.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(val appDataBase: AppDataBase): ViewModel() {
    val firstText = MutableLiveData<String>("Hello First fragment")
    val listOfUsers = appDataBase.UserDao().getAll()

    fun changeFirstText(text: String){
        firstText.value = text
    }

    suspend fun addName(firstName: String, lastName: String){
        val user = User(
            uid = 0,
            firstName = firstName,
            lastName = lastName
        )

        appDataBase.UserDao().insert(user)
    }

    suspend fun deleteAll() {
        appDataBase.UserDao().deleteAll()
    }



}