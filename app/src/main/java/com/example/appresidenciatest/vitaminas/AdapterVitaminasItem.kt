package com.example.appresidenciatest.vitaminas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.appresidenciatest.R
import kotlinx.android.synthetic.main.listitem_vitaminas.view.*

class AdapterVitaminasItem  : RecyclerView.Adapter<AdapterVitaminasItem.MyViewHolder>() {
    private var list = ArrayList<VitaminItem>()
    var onDeleteItemClickListener:onDeleteItemCliCkListener?=null

    interface onDeleteItemCliCkListener{
        fun onDeleteItem(vitaminasItem: VitaminItem, position: Int)
    }


    inner  class MyViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.listitem_vitaminas, parent, false)){
        fun bind(vitaminasItem: VitaminItem)= with(itemView){
            etnombre.text = vitaminasItem.nombre
            etabreviaturas.text = vitaminasItem.abreviaturas
            btnDelete.setOnClickListener{
                onDeleteItemClickListener?.onDeleteItem(vitaminasItem, adapterPosition)

            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(parent)


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setList(list: ArrayList<VitaminItem>){
        this.list = list
        notifyDataSetChanged()
    }

    fun addItem(vitaminasItem: VitaminItem){
        list.add(vitaminasItem)
        notifyItemInserted(list.size - 1)
    }

    fun deleteItem(position: Int){
        list.removeAt(position)
        notifyItemRemoved(position)
    }
}