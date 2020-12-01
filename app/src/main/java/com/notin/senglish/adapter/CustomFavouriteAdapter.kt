package com.notin.senglish.adapter

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.notin.senglish.R
import com.notin.senglish.model.Word


class CustomFavouriteAdapter(context:Context, arrWords:ArrayList<Word>):
    RecyclerView.Adapter<CustomFavouriteAdapter.ItemViewHolder>()
{
   private val context=context
    private var arrWords= arrWords

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val myView=(context as Activity).layoutInflater.inflate(R.layout.item_favourite_recycler,parent,false)
        return ItemViewHolder(myView)
    }

    override fun getItemCount(): Int {
        return arrWords.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.txtWord!!.text=arrWords[position].wordEnglish

    }
    
    class ItemViewHolder : RecyclerView.ViewHolder {
        var txtWord:TextView?=null
        constructor(itemView:View):super(itemView)
        {
            txtWord = itemView.findViewById<TextView>(R.id.txt_word)
        }
    }





}

