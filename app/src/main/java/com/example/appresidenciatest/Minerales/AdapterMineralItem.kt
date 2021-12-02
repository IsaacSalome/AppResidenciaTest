package com.example.appresidenciatest.Minerales

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appresidenciatest.R
import com.example.appresidenciatest.vitaminas.VitaminItem
import kotlinx.android.synthetic.main.listitem_minerales.view.*
import kotlinx.android.synthetic.main.listitem_vitaminas.view.*
import kotlinx.android.synthetic.main.listitem_vitaminas.view.btnDelete

class AdapterMineralItem  : RecyclerView.Adapter<AdapterMineralItem.MyViewHolder>() {
    private var list = ArrayList<MineralesItem>()
    var onDeleteItemClickListener: onDeleteItemCliCkListener? = null

    interface onDeleteItemCliCkListener {
        fun onDeleteItem(mineralesItem: MineralesItem, position: Int)
    }


    inner class MyViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.listitem_minerales, parent, false
        )
    ) {
        fun bind(mineralesItem: MineralesItem) = with(itemView) {
            textnombre.text = mineralesItem.nombre
            textbreviatura.text = mineralesItem.abreviaturas
            btnDelete.setOnClickListener {
                onDeleteItemClickListener?.onDeleteItem(mineralesItem, adapterPosition)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(parent)


    override fun onBindViewHolder(holder: AdapterMineralItem.MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setList(list: ArrayList<MineralesItem>){
        this.list = list
        notifyDataSetChanged()
    }

    fun addItem(mineralesItem: MineralesItem){
        list.add(mineralesItem)
        notifyItemInserted(list.size - 1)
    }

    fun deleteItem(position: Int){
        list.removeAt(position)
        notifyItemRemoved(position)
    }


}