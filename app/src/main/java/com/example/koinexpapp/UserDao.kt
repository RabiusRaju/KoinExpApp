package com.example.koinexpapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(item:DataModel)


    @Query("select * from userTable")
    fun getAllUser(): LiveData<List<DataModel>>

    @Query("UPDATE userTable SET fullName =:updateName, Designation=:updateDesignation where userID=:id")
    fun updateUser(id: Int, updateName: String, updateDesignation: String)

    @Delete
    fun deleteUser(deleteUser: DataModel)
}