package com.example.login.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.login.R
import com.example.login.databinding.MainFragmentBinding
import com.example.login.ui.login.user

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val TAG: String = "LogMainFragment"
    private val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private var navController: NavController? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = MainFragmentBinding.inflate(inflater, container, false)

        val user =  arguments?.getParcelable<user>("user")
        Log.i(TAG, "Bundle data : $user")

        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        viewModel.actions.observe(this, Observer<actions>{ action ->
            loginActions(action)
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    private fun loginActions(action: actions?) {
       when(action?.action){
           0 -> {
               Log.i(TAG, action.detail)
               navController!!.navigate(R.id.action_mainFragment_to_loginFragment)
           }
       }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
//            R.id.about -> Toast.makeText(context, "About app.!", Toast.LENGTH_LONG).show()
            R.id.about -> Toast.makeText(context, getString(R.string.AboutApp), Toast.LENGTH_LONG).show()
            R.id.logout -> viewModel.logout()
            R.id.delete -> Log.i(TAG, "Delete button")
        }

        return super.onOptionsItemSelected(item)
    }

}