package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.adapters.CustomRecyclerAdapter
import com.example.recyclerviewexample.model.Item
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var arrayList: ArrayList<Item>
    lateinit var customAdaper: CustomRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        //recyclerView.layoutManager = GridLayoutManager(this, 3)


        arrayList = leerLista()

        customAdaper = CustomRecyclerAdapter(arrayList, this){item->click(item)}
        recyclerView.adapter = customAdaper


        spinner = findViewById<Spinner>(R.id.spinner)
        val arrayBanderas = resources.getStringArray(R.array.banderas)
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayBanderas)
        spinner.adapter = adapterSpinner
    }

    fun leerLista(seleccion: String="Todas") : ArrayList<Item>{
        var arrayRdo = ArrayList<Item>()

        var bufferedReaderRaw: BufferedReader = BufferedReader(InputStreamReader(resources!!.openRawResource(R.raw.lista)))
        bufferedReaderRaw.forEachLine {
                var item = Item(it)
                if (seleccion.equals("Todas", true)){
                    arrayRdo.add(item)
                }
                else{
                    if (seleccion.equals(item.bandera, true)){
                        arrayRdo.add(item)
                    }
                }
        }
        bufferedReaderRaw.close()

        return arrayRdo
    }

    fun click(itemValue:Item){
        Toast.makeText(applicationContext,"Valor : ${itemValue.campo1 + "-" + itemValue.campo2+ "-"+itemValue.campo3+ "-"+itemValue.campo4+ "-" +itemValue.campo5}", Toast.LENGTH_LONG).show()
    }

    fun clickBandera(texto: String){
        Toast.makeText(applicationContext,"Bandera : ${texto}", Toast.LENGTH_LONG).show()
    }

    fun onActualizar(view: View) {
        var seleccion = spinner.selectedItem.toString()
        arrayList.clear()
        arrayList = leerLista(seleccion)
        customAdaper.itemList = arrayList

        customAdaper.notifyDataSetChanged()
    }
}