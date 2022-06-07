package com.example.exm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exam.car


@Database(entities = [car::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun championDao(): CarDao


    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDataBase::class.java, "champions")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance!!
        }
    }
}