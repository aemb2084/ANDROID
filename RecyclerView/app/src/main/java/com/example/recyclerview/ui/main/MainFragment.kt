package com.example.recyclerview.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class MainFragment : Fragment() {

    private var TAG: String = "MainFragmentLogs"
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var mRecyclerView: RecyclerView
    val mAdapter: CustomAdapter = CustomAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.main_fragment, container, false)

        context?.let { context ->
            recyclerViewSetup(view, context)
        }

        return view
    }

    fun setUpRecyclerView(){
        // TODO( "Not yet implemented")
    }

    fun getSuperheros(): MutableList<ItemsViewModel>{
        var superheros:MutableList<ItemsViewModel> = ArrayList()
        superheros.add(ItemsViewModel("Spiderman", "Marvel",  "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"))
        superheros.add(ItemsViewModel("Daredevil", "Marvel",  "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"))
        superheros.add(ItemsViewModel("Wolverine", "Marvel",  "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"))
        superheros.add(ItemsViewModel("Batman", "DC",  "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"))
        superheros.add(ItemsViewModel("Thor", "Marvel", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"))
        superheros.add(ItemsViewModel("Flash", "DC", "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"))
        superheros.add(ItemsViewModel("Green Lantern", "DC", "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"))
        superheros.add(ItemsViewModel("Wonder Woman", "DC", "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"))
        return superheros
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        Log.i(TAG,"Fragmento creado")
    }

    fun recyclerViewSetup(view: View, context: Context){
        mRecyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter.RecyclerAdapter(getSuperheros(), context)
        mRecyclerView.adapter = mAdapter
    }

}