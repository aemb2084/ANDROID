package com.example.recyclerview.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.squareup.picasso.Picasso

class CustomAdapter : RecyclerView.Adapter<ViewHolder>() {

    var Heroes: MutableList<ItemsViewModel> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(Heroes : MutableList<ItemsViewModel>, context: Context){
        this.Heroes = Heroes
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.text_row_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = Heroes.get(position)
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return Heroes.size
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val mHeroe  = view.findViewById(R.id.Heroe) as TextView
    val mLiga = view.findViewById(R.id.Liga) as TextView
    val mHeroeImage = view.findViewById(R.id.HeroeImage) as ImageView

    fun bind (texts:ItemsViewModel, context: Context){
        mHeroe.text = texts.Heroe
        mLiga.text = texts.Liga
        itemView.setOnClickListener( View.OnClickListener {
            Toast.makeText(context, texts.Heroe, Toast.LENGTH_SHORT).show()
            }
        )
       mHeroeImage.loadURL(texts.HeroURL)
    }
    fun ImageView.loadURL(url: String){
        Picasso.get().load(url).into(this)
    }
}