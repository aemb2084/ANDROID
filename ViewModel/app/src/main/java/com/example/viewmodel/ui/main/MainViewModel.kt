package com.example.viewmodel.ui.main

import android.widget.AdapterView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val operResult: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private lateinit var operation : String

    init{
        operResult.value = "Operation result."
    }

    fun chargeOper(oper: String){
        operation = oper
    }

    fun doOper(num1: Float, num2: Float){
        when (operation){
            "add" -> operResult.value = (num1 + num2).toString()
            "sub" -> operResult.value = (num1 - num2).toString()
            "mul" -> operResult.value = (num1 * num2).toString()
            "div" -> operResult.value = (num1 / num2).toString()
        }
    }

}