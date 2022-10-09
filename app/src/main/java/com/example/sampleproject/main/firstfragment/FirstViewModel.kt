package com.example.sampleproject.main.firstfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleproject.data.local.AppDataBase
import com.example.sampleproject.data.local.entity.User
import com.example.sampleproject.data.remote.RIckAndMortyService
import com.example.sampleproject.data.remote.model.response.CharacterInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val appDataBase: AppDataBase,
    private val rIckAndMortyService: RIckAndMortyService
): ViewModel() {

    val firstText = MutableLiveData<String>("Hello First fragment")

    val listOfUsers = appDataBase.UserDao().getAll()

    val characterList = MutableLiveData<List<CharacterInfo>>()

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

    suspend fun getCharacters(){
        rIckAndMortyService.getCharacters().body()?.also { characterList ->
            this.characterList.value = characterList.results
        }
    }


}