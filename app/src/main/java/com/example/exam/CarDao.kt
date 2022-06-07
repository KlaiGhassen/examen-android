package com.example.exm

import androidx.room.*
import com.example.exam.car

@Dao
interface CarDao {
    @Insert
fun insert(champ: car)

    @Update
    fun update(champ: car)

    @Delete
    fun delete(champ: car)

    @Query("SELECT * FROM car")
    fun getAllchamps(): MutableList<car>
}