package com.example.login.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavAction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.login.R
import com.example.login.databinding.LoginFragmentBinding

class LoginFragment : Fragment(){

    private lateinit var viewModel: LoginViewModel
    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!
    private var navController: NavController? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = LoginFragmentBinding.inflate(inflater, container, false)

        binding.personalLogin.setOnClickListener {

            navController!!.navigate(R.id.action_loginFragment_to_mainFragment)

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        navController = Navigation.findNavController(view)

    }

}