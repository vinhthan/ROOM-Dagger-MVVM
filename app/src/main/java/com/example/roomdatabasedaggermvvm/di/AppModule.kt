package com.example.roomdatabasedaggermvvm.di

import android.app.Application
import android.content.Context
import com.example.roomdatabasedaggermvvm.database.AppDatabase
import com.example.roomdatabasedaggermvvm.database.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Singleton
    @Provides
    fun getUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.getUserDao()
    }

    @Singleton
    @Provides
    fun getRoomDbInstance(): AppDatabase {
        return AppDatabase.getAppDatabaseInstance(provideAppContext())
    }

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return application.applicationContext
    }

}