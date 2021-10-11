package com.example.roomdatabasedaggermvvm.di

import com.example.roomdatabasedaggermvvm.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)

}