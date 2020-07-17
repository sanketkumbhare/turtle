package com.turtle.nest.repository.room

import androidx.room.*
import com.turtle.nest.model.data.UserInfo

@Dao
interface UserInfoDAO {

    @Insert
    fun insert(info: UserInfo)

    @Delete
    fun delete(info: UserInfo)

    @Update
    fun update(info: UserInfo)

    @Query("Select * from UserInfo")
    fun getUserInfo(): UserInfo

}