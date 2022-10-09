package com.example.sampleproject.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sampleproject.data.local.dao.UserDao
import com.example.sampleproject.data.local.entity.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
    )
abstract class AppDataBase: RoomDatabase() {
    abstract fun UserDao(): UserDao

    //Static Method
    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { appDatabase ->
                    instance = appDatabase }
            }

        private fun buildDatabase(appContext: Context) = Room.databaseBuilder(
            appContext,
            AppDataBase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration().build()
    }
}