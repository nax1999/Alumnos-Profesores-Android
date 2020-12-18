package com.example.recyclerviewexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.MainActivity
import com.example.recyclerviewexample.R
import com.example.recyclerviewexample.model.Item

class CustomRecyclerAdapter(var itemList: ArrayList<Item>, private val actividad:MainActivity, private val click:(Item) -> Unit)
    : RecyclerView.Adapter<CustomRecyclerAdapter.MiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_list, parent, false)
        val viewHolder = MiViewHolder(v)

        viewHolder.actividad = actividad
        return viewHolder
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        holder.bindItem(itemList[position])
        holder.itemView.setOnClickListener{click(itemList[position])}
    }


    class MiViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var bandera: ImageView
        var campo1:TextView
        var campo2:TextView
        var campo3:TextView
        var campo4:TextView
        var campo5:TextView
        lateinit var actividad:MainActivity

        init{
            bandera = itemView.findViewById(R.id.bandera) as ImageView
            campo1 = itemView.findViewById<TextView>(R.id.campo1)
            campo2 = itemView.findViewById(R.id.campo2) as TextView
            campo3 = itemView.findViewById(R.id.campo3) as TextView
            campo4 = itemView.findViewById(R.id.campo4) as TextView
            campo5 = itemView.findViewById(R.id.campo5) as TextView

        }

        fun bindItem(item: Item) {
            campo1.text = item.campo1
            campo2.text = item.campo2
            campo3.text = item.campo3
            campo4.text = item.campo4
            campo5.text = item.campo5

            if (item.bandera.equals("Profesores")){
                bandera.setImageResource(R.drawable.profesor)
                bandera.setOnClickListener{actividad.clickBandera("Profesores")}
            }
            else{
                bandera.setImageResource(R.drawable.alumno)
                bandera.setOnClickListener{actividad.clickBandera("Alumnos")}
            }
        }
    }


}