package com.example.roomdatabasedaggermvvm

import android.app.Application
import com.example.roomdatabasedaggermvvm.di.AppComponent
import com.example.roomdatabasedaggermvvm.di.AppModule
import com.example.roomdatabasedaggermvvm.di.DaggerAppComponent

class MyApp : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}