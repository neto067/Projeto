package com.example.myapplication2

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import kotlin.toString

class MainActivity : ComponentActivity() {

    private var itemCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemAdapter()

        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editName = findViewById<EditText>(R.id.editName)
        val editQnt = findViewById<EditText>(R.id.editQnt)
        val editPrco = findViewById<EditText>(R.id.editPrco)
        val editDesc = findViewById<EditText>(R.id.editDesc)

        button.setOnClickListener {
            if (editName.text.isEmpty() || editQnt.text.isEmpty() || editPrco.text.isEmpty()) {
                if (editName.text.isEmpty()) editName.error = "Preencha o nome"
                if (editQnt.text.isEmpty()) editQnt.error = "Preencha a quantidade"
                if (editPrco.text.isEmpty()) editPrco.error = "Preencha o preço"
                return@setOnClickListener
            }

            itemCount++

            val item = ItemModel(
                numero = itemCount,
                nome = editName.text.toString(),
                quantidade = editQnt.text.toString(),
                preco = editPrco.text.toString(),
                descricao = editDesc.text.toString()
            )

            itemsAdapter.addItem(item)

            editName.text.clear()
            editQnt.text.clear()
            editPrco.text.clear()
            editDesc.text.clear()
        }
    }
}







