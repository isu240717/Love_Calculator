package com.example.love_calculator.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity("love-table")
data class LoveModel(

    val fname: String,
    val sname: String,
    val percentage: String,
    val result: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
) : Serializable {
    override fun toString(): String {
        return "\n$percentage \n$fname \n$sname \n$result\n"
    }

}