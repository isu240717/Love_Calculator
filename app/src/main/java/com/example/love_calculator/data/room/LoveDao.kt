package com.example.love_calculator.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.love_calculator.remote.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(lioveModel: LoveModel)
/* ORDER BY fname ASC*/
    @Query ("SELECT * FROM `love-table` ORDER BY fname ASC")
    fun getAll(): List<LoveModel>
}