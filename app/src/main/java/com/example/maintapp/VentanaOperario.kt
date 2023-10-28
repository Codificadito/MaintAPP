package com.example.maintapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VentanaOperario : RecyclerView.Adapter<VentanaOperario.ViewHolder>() {


    val titles = arrayOf("Mantenimiento","Incidencia","Urgencia","Mantenimiento","Incidencia","Urgencia","Mantenimiento","Incidencia","Urgencia")
    val details = arrayOf("Mantenimiento programamdo de 2 asensores","No funcionan las luces del asensor","El asensor abre las puertas en cualquier momento","Mantenimiento programamdo de 2 asensores","No funcionan las luces del asensor","El asensor abre las puertas en cualquier momento","Mantenimiento programamdo de 2 asensores","No funcionan las luces del asensor","El asensor abre las puertas en cualquier momento")
    val adress = arrayOf("Av.Libertdor 2255","Viamonte 933","Av.Santa fe 1399","Av.Libertdor 2255","Viamonte 933","Av.Santa fe 1399","Av.Libertdor 2255","Viamonte 933","Av.Santa fe 1399")
    val image = arrayOf(R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground)





    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v =LayoutInflater.from(viewGroup.context).inflate(R.layout.ventana_operario_0,viewGroup,false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text=titles[i]
        viewHolder.itemDetail.text=details[i]
        viewHolder.itemAdress.text=adress[i]
        viewHolder.itemImage.setImageResource(image[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemImage: ImageView
        var itemTitle: TextView
        var itemAdress:TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.imageTaskId)
            itemTitle = itemView.findViewById(R.id.titleTextView)
            itemAdress = itemView.findViewById(R.id.addressTextView)
            itemDetail = itemView.findViewById(R.id.descriptionTextView)
        }
    }
}
