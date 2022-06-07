package com.example.exam

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exm.AppDataBase

class adapter2 (val carsList: MutableList<car>) :  RecyclerView.Adapter<adapter2.favoriteViewHolder>()  {


    class favoriteViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val favoritepic = itemView.findViewById<ImageView>(R.id.champPic)
        val nom = itemView.findViewById<TextView>(R.id.Nom)
        val dispo = itemView.findViewById<TextView>(R.id.dispo)
        val prix = itemView.findViewById<TextView>(R.id.prix)
        val btn_delete = itemView.findViewById<ImageButton>(R.id.btnLike)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): favoriteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_model2, parent, false)
        return favoriteViewHolder(view)    }

    override fun onBindViewHolder(holder: favoriteViewHolder, position: Int) {
        val name = carsList[position].Nom
        val dispo = carsList[position].dispo
        val champPic = carsList[position].carPic
        val prix = carsList[position].prix
        holder.favoritepic.setImageResource(champPic)
        holder.nom.text = name
        holder.dispo.text = dispo
        holder.prix.text = prix.toString()
        holder.btn_delete.setOnClickListener {
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete from favorite")
                .setMessage(holder.itemView.context.getString(R.string.deleteMessageUniv, carsList[position].Nom))
                .setPositiveButton("Yes"){ dialogInterface, which ->
                    AppDataBase.getDatabase(holder.itemView.context).championDao().delete(carsList[position])
                    carsList.removeAt(position)
                    notifyDataSetChanged()

                }.setNegativeButton("No"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }.create().show()

        }    }

    override fun getItemCount(): Int {
        return carsList.size
    }
}