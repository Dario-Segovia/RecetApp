package com.santosgo.recetapp.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.santosgo.recetapp.RecetasItem

class RecetasViewModel : ViewModel() {
    private val _favoritos = MutableLiveData<MutableList<RecetasItem>>(mutableListOf())
    val favoritos: LiveData<MutableList<RecetasItem>> get() = _favoritos

    fun agregarFavorito(receta: RecetasItem) {
        val listaActualizada = _favoritos.value ?: mutableListOf()
        if (!listaActualizada.contains(receta)) {
            listaActualizada.add(receta)
            _favoritos.value = listaActualizada
        }
    }

    fun eliminarFavorito(receta: RecetasItem) {
        val listaActualizada = _favoritos.value ?: mutableListOf()
        listaActualizada.remove(receta)
        _favoritos.value = listaActualizada
    }
}
