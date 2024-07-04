package com.matrix.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import kotlin.math.hypot

class TaskRecyclerAdapter(var context:Context, var list: ArrayList<TaskDataClass>) :RecyclerView.Adapter<TaskRecyclerAdapter.Viewholder> (){
    class Viewholder(var view:View) :RecyclerView.ViewHolder(view){
        var title:TextView?=view.findViewById(R.id.txtTitle)
        var description:TextView?=view.findViewById(R.id.txtDescription)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.title?.setText(list[position].title)
        holder.description?.setText(list[position].description)
        when (list[position].priority) {
            1 ->  holder.itemView.setBackgroundColor(ContextCompat.getColor(context,R.color.priority_high))  // High priority
             2 -> holder.itemView.setBackgroundColor(ContextCompat.getColor(context,R.color.priority_medium))
            else ->holder.itemView.setBackgroundColor(ContextCompat.getColor(context,R.color.priority_low))
        }

    }


}