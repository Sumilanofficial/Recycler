package com.matrix.recycler

interface TaskClickInterface {
    fun updateTask(position : Int)
    fun deleteTask(position:Int)
    fun itemClick(position: Int)
}