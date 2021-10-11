package com.example.roomdatabasedaggermvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabasedaggermvvm.database.UserDao
import com.example.roomdatabasedaggermvvm.database.UserEntity
import javax.inject.Inject

class MainActivityViewModel (application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var userDao: UserDao

    var allUserList: MutableLiveData<List<UserEntity>>

    init {
        (application as MyApp).getAppComponent().inject(this)
        allUserList = MutableLiveData()
        getAllUser()
    }

    fun getAllUserObservable(): MutableLiveData<List<UserEntity>>{
        return allUserList
    }

    private fun getAllUser(){
        val list = userDao.getAllUser()
        allUserList.postValue(list)
    }

    fun insertUser(userEntity: UserEntity) {
        userDao.insertUser(userEntity)
        getAllUser()
    }

}