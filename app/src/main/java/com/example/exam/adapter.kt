package com.example.exam

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.exm.AppDataBase
import java.lang.Exception

class adapter (val carsList: MutableList<car>) :  RecyclerView.Adapter<adapter.viewHolder>() {

    class viewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val carpic = itemView.findViewById<ImageView>(R.id.champPic)
        val nom = itemView.findViewById<TextView>(R.id.Nom)
        val dispo = itemView.findViewById<TextView>(R.id.dispo)
        val prix = itemView.findViewById<TextView>(R.id.prix)
        val btnLike = itemView.findViewById<ImageButton>(R.id.btnLike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
            val rootView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycle_model, parent, false)
            return viewHolder (rootView)

    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val name = carsList[position].Nom
        val dispo = carsList[position].dispo
        val champPic = carsList[position].carPic
        val prix = carsList[position].prix
        holder.carpic.setImageResource(champPic)
        holder.nom.text = name
        holder.dispo.text = dispo
        holder.prix.text = prix.toString()
        holder.btnLike.setOnClickListener {
            try {
                AlertDialog.Builder(holder.itemView.context)
                    .setTitle("BUY PROGRMING ANDROID WITH KOTLIN")
                    .setMessage(holder.itemView.context.getString(R.string.buymsg, carsList[position].Nom))
                    .setPositiveButton("Yes"){ dialogInterface, which ->
                        AppDataBase.getDatabase(holder.itemView.context).championDao().insert(
                            car(
                                position,
                                carsList[position].carPic,
                                holder.nom.text.toString(),
                                holder.dispo.text.toString(),
                                holder.prix.text.toString().toInt()

                            )
                        )

                    }.setNegativeButton("No"){dialogInterface, which ->
                        dialogInterface.dismiss()
                    }.create().show()



            }
            catch (ex: Exception){
                Toast.makeText(holder.itemView.context, "Could not add the car to favorite !", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun getItemCount(): Int {
       return carsList.size
    }
}