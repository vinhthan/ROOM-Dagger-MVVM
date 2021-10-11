package com.example.roomdatabasedaggermvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        private var dbInstance: AppDatabase? = null
        fun getAppDatabaseInstance(context: Context): AppDatabase{
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder<AppDatabase>(context.applicationContext,
                AppDatabase::class.java,
                "app_database")
                    .allowMainThreadQueries()
                    .build()
            }

            return dbInstance!!
        }
    }

}