package com.example.roomdatabasedaggermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabasedaggermvvm.database.UserEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add.setOnClickListener {
            val userEntity = UserEntity(name = edt_name.text.toString().trim(),
                age = edt_age.text.toString().trim())

            viewModel.insertUser(userEntity)
            tv_result.text = ""
        }

        initViewModel()
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.getAllUserObservable().observe(this, object : Observer<List<UserEntity>>{
            override fun onChanged(t: List<UserEntity>?) {
                tv_result.text = ""
                t?.forEach {
                    tv_result.append(it.name + "  " + it.age + "\n")
                }
            }

        })
    }
}