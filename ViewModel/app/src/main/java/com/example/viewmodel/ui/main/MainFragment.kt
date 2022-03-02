package com.example.viewmodel.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.viewmodel.R
import com.example.viewmodel.databinding.MainFragmentBinding
import java.util.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val TAG: String = "MainFragmentLogs"
    private lateinit var _binding : MainFragmentBinding
    private var num1 : Float = 0.0f
    private var num2 : Float = 0.0f
    val viewModel by viewModels<MainViewModel>()
    private var mOperation : String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = MainFragmentBinding.inflate(inflater, container, false)

        return  _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val operations = resources.getStringArray(R.array.operations)
        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.list_item,
            operations
        )

        _binding.opOptions.setOnItemClickListener { parent, view, position, id ->

            mOperation = parent.getItemAtPosition(position).toString()
            viewModel.chargeOper(mOperation)

        }

        (_binding.opOptions as? AutoCompleteTextView)?.setAdapter(adapter)

        _binding.calculate.setOnClickListener{
            val emptyChecker1 = _binding.number1.text.toString()
            val emptyChecker2 = _binding.number2.text.toString()

            if (emptyChecker1 != "" && emptyChecker2 != "" ){
                num1 = _binding.number1.text.toString().toFloat()
                num2 = _binding.number2.text.toString().toFloat()
            }else{
                Toast.makeText(requireContext(), "Please insert the numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (mOperation != ""){
                viewModel.doOper(num1, num2)
            }else{
                Toast.makeText(requireContext(), "Please select operation", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

        viewModel.operResult.observe(viewLifecycleOwner, androidx.lifecycle.Observer { result ->
            _binding.operResult.text = result
        })

    }

}