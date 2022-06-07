package com.example.exam

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


const val PICTURE="PICTURE"
const val NAME="NAME"
const val DISPO="DISPO"
const val PRIX="PRIX"
@Entity(tableName = "car")
data class car(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "car_pic")
    val carPic:Int,
    @ColumnInfo(name = "nom")
    val Nom:String,
    @ColumnInfo(name = "dispo")
    val dispo:String,
    @ColumnInfo(name = "prix")
    val prix:Int
){
}