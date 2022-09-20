package com.example.koinexpapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val userDao: UserDao) : ViewModel() {
    fun getAllUser(): LiveData<List<DataModel>> = userDao.getAllUser()

    suspend fun addUser(userAdd: DataModel) {
        userDao.addUser(userAdd)
    }

    fun updateUser(id: Int, updateName: String, updateDesignation: String) {
        userDao.updateUser(id, updateName, updateDesignation)
    }

    fun deleteUser(userDelete: DataModel) {
        userDao.deleteUser(userDelete)

    }
}