package com.example.sampleproject.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.sampleproject.data.local.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE first_name LIKE :firstName LIMIT 1")
    fun findByFirstName(firstName: String): LiveData<User>

    @Insert
    suspend fun insert(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAll()


}