package com.example.login.ui.login

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {

    private var TAG: String = "LogLoginFragmentViewModel"
    private lateinit var auth: FirebaseAuth

    val register: MutableLiveData<registerStatus> by lazy {
        MutableLiveData<registerStatus>()
    }

    val login: MutableLiveData<loginStatus> by lazy{
        MutableLiveData<loginStatus>()
    }

    fun SignUp(credentials: credentials, activity: FragmentActivity?){

        auth = Firebase.auth
        activity?.let { activity ->
            auth.createUserWithEmailAndPassword(credentials.email, credentials.password)
                .addOnCompleteListener(activity) { task ->

                    if (task.isSuccessful){
                        Log.i(TAG, "Successfully Singed Up: Token -> ${task.result.user?.uid}")
                        var tempRegister = registerStatus(true,task.result.user?.uid.toString())
                        register.value = tempRegister
                    } else {
                        Log.i(TAG, "Singed Up: ${task.exception}")
                        var tempRegister = registerStatus(false,task.exception.toString())
                        register.value = tempRegister
                    }

                }
        }
    }

    fun SignIn(credentials: credentials, activity: FragmentActivity?){

        auth = Firebase.auth
        activity?.let {
            auth.signInWithEmailAndPassword(credentials.email, credentials.password)
                .addOnCompleteListener(it){ task ->
                    if (task.isSuccessful){
                        Log.i(TAG, "Successfully Logged In:")
                        var tempUser = user(
                            auth.currentUser?.displayName.toString(),
                            auth.currentUser?.email.toString(),
                            auth.currentUser?.uid.toString()
                        )
                        var tempLoginStatus = loginStatus(
                            true,
                            task.result.toString(),
                            tempUser
                        )
                        login.value = tempLoginStatus
                    } else {

                    }
                }
        }
    }

}