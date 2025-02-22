package com.santosgo.recetapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santosgo.recetapp.R
import com.santosgo.recetapp.RecetasItem

class RecetasAdapter(
    private val equiposLista: List<RecetasItem>,
    private val onClickListener: (RecetasItem) -> Unit,
    private val onFavoriteClick: (RecetasItem) -> Unit // Nueva función para favoritos
) : RecyclerView.Adapter<RecetaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecetaViewHolder(
            layoutInflater.inflate(R.layout.fragment_recetas, parent, false)
        )
    }

    override fun getItemCount(): Int = equiposLista.size

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {
        val itemEquipo = equiposLista[position]
        holder.render(itemEquipo, onClickListener, onFavoriteClick) // Pasamos el onFavoriteClick
    }




}
