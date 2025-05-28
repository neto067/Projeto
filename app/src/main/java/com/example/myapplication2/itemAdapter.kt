package com.example.myapplication2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button

class ItemAdapter : RecyclerView.Adapter <ItemAdapter.ItemViewHolder> () {

    private  val items = mutableListOf<ItemModel>()

    fun addItem(newItem: ItemModel){
        items.add(newItem)
        items.sortBy {it.nome }
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)


        holder.remover.setOnClickListener {
            removeItem(holder.adapterPosition)
        }
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTitulo = itemView.findViewById<TextView>(R.id.textViewTitulo)
        private val textViewDetalhes = itemView.findViewById<TextView>(R.id.textViewDetalhes)
        val remover = itemView.findViewById<Button>(R.id.remove)


        fun bind(item: ItemModel){
            textViewTitulo.text = "${item.numero}. ${item.nome}"
            textViewDetalhes.text = "Qtd: ${item.quantidade} | Preço: R$${item.preco}\n${item.descricao}"
        }


    }
}




