package com.example.login.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainViewModel : ViewModel() {

    private var TAG: String = "LogLoginFragmentViewModel"
    private lateinit var auth: FirebaseAuth

    val actions: MutableLiveData<actions> by lazy {
        MutableLiveData<actions>()
    }

    fun logout() {

        Firebase.auth.signOut()
        actions.value = actions(
            true,
            "Logout seccess",
            0
        )

    }
    // TODO: Implement the ViewModel
}