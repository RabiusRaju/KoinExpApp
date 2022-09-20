package com.example.koinexpapp

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataModel::class], version = 1, exportSchema = false)
abstract class UserDB : RoomDatabase() {
    abstract val userDao : UserDao

    val userDB = module {
        fun provideDataBase(application: Application): UserDB {
            return Room.databaseBuilder(application, UserDB::class.java, "USERDB")
                .fallbackToDestructiveMigration()
                .build()
        }

        fun provideDao(dataBase: UserDB): UserDao {
            return dataBase.userDao
        }
        single { provideDataBase(androidApplication()) }
        single { provideDao(get()) }

    }

    val  mainViewModel= module{
        viewModel {
            MainViewModel(get())
        }
    }
}